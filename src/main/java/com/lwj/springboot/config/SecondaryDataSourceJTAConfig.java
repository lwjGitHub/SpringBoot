package com.lwj.springboot.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration
@MapperScan(basePackages = "com.lwj.springboot.generator.kmin",   //注意这里
        sqlSessionTemplateRef = "secondarySqlSessionTemplate")
public class SecondaryDataSourceJTAConfig {

    @Bean("secondaryDataSource")
    @ConfigurationProperties(prefix = "secondarydb")
    @Primary
    public DataSource secondaryDataSource() {
        return new AtomikosDataSourceBean();
    }

    @Bean("secondarySqlSessionFactory")
    @Primary
    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier("secondaryDataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        bean.setTypeAliasesPackage("com.lwj.springboot.generator.kmin");   //注意这里
        return bean.getObject();
    }

    @Bean("secondarySqlSessionTemplate")
    @Primary
    public SqlSessionTemplate secondarySqlSessionTemplate(
            @Qualifier("secondarySqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
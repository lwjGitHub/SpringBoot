package com.lwj.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author K_MAX
 */
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@MapperScan(basePackages = {"com.lwj.springboot.generator"})
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}


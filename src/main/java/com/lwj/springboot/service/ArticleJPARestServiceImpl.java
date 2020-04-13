package com.lwj.springboot.service;

import com.lwj.springboot.dao.Article;
import com.lwj.springboot.dao.ArticleRepository;
import com.lwj.springboot.model.ArticleVO;
import com.lwj.springboot.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleJPARestServiceImpl implements  ArticleRestService  {

    //将JPA仓库对象注入
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    public ArticleVO saveArticle(ArticleVO article) {

        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);    //保存一个对象到数据库，insert

        return  article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);   //根据id删除1条数据库记录
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);   //更新一个对象到数据库，仍然使用save方法
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);  //根据id查找一条数据
        return dozerMapper.map(article.get(),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articleLis = articleRepository.findAll();  //查询article表的所有数据
        return DozerUtils.mapList(articleLis,ArticleVO.class);
    }
}
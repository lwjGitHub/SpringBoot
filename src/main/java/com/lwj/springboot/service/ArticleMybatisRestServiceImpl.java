package com.lwj.springboot.service;

import com.lwj.springboot.generator.Article;
import com.lwj.springboot.generator.ArticleDao;
import com.lwj.springboot.model.ArticleVO;
import com.lwj.springboot.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleDao articleDao;


    //新增
    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleDao.insert(articlePO);
        return null;
    }

    //删除
    @Override
    public void deleteArticle(Integer id) {
        articleDao.deleteByPrimaryKey(id);
    }

    //更新
    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleDao.updateByPrimaryKeySelective(articlePO);
    }

    //查询
    @Override
    public ArticleVO getArticle(Integer id) {
        return dozerMapper.map(articleDao.selectByPrimaryKey(id),ArticleVO.class);
    }
    //查询所有
    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleDao.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);
    }
}
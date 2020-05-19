package com.lwj.springboot.service;

import com.lwj.springboot.generator.kmax.Article;
import com.lwj.springboot.generator.kmax.ArticleDao;
import com.lwj.springboot.generator.kmin.Message;
import com.lwj.springboot.generator.kmin.MessageDao;
import com.lwj.springboot.model.ArticleVO;
import com.lwj.springboot.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleDao articleDao;

    @Resource
    private MessageDao messageDao;

    //新增
    @Override
    @Transactional
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleDao.insert(articlePO);
        Message message = new Message();
        message.setName("lwj");
        message.setContent("da帅哥");
        messageDao.insert(message);
//     int temp = 4/0;
        return article;
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
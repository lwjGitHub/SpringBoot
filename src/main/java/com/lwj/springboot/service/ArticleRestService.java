package com.lwj.springboot.service;

import com.lwj.springboot.model.ArticleVO;

import java.util.List;

public interface ArticleRestService{

    public ArticleVO saveArticle(ArticleVO article);

    public void deleteArticle(Integer id);

    public void updateArticle(ArticleVO article);

    public ArticleVO getArticle(Integer id);

    public List<ArticleVO> getAll();
}

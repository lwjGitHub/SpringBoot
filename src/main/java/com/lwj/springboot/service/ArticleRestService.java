package com.lwj.springboot.service;

import com.lwj.springboot.model.AjaxResponse;
import com.lwj.springboot.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author K_MAX
 */
@Slf4j
@Service
public class ArticleRestService {

    public String saveArticle( Article article){
        log.info("saveArticle:{}",article);
        return "测试";
    }
}

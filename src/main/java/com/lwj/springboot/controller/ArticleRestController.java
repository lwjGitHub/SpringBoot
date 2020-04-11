package com.lwj.springboot.controller;


import com.lwj.springboot.model.AjaxResponse;
import com.lwj.springboot.model.Article;
import com.lwj.springboot.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author K_MAX
 * @since Restful接口
 */

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource(name = "articleRestJDBCServiceImpl")
    ArticleRestService articleJDBCService;

    //@RequestMapping(value = "/article",method = POST,produces ="application/json")
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article){

        log.info("articleRestService return :"+ articleJDBCService.saveArticle(article));
        return AjaxResponse.success(article);
    }
    //@RequestMapping(value = "/article/{id}",method = DELETE,produces = "application/json")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id){
        articleJDBCService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    //@RequestMapping(value = "/article/{id}",method = PUT,produces = "application/json")
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id,@RequestBody Article article){
        article.setId(id);
        articleJDBCService.updateArticle(article);
        return AjaxResponse.success(article);
    }
    //@RequestMapping(value = "/article/{id}",method = GET,produces = "application/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id){
       //Article article = Article.builder().id(3L).author("LWJ").content("早悟兰因").createTime(new Date()).title("无").build();
        return AjaxResponse.success( articleJDBCService.getArticle(id));
    }

    @GetMapping("/article")
    public AjaxResponse getArticleAll(){
        //Article article = Article.builder().id(3L).author("LWJ").content("早悟兰因").createTime(new Date()).title("无").build();
        return AjaxResponse.success( articleJDBCService.getAll());
    }


}

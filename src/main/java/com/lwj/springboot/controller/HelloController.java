package com.lwj.springboot.controller;

import com.lwj.springboot.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author K_MAX
 * @create 2020/3/23
 */
@Slf4j
@RestController
public class HelloController {
   @RequestMapping(value = "/hello")
    public String hello() {
       ArticleVO article = new ArticleVO();

       String s = "Hello Spring Boot!热部署111";
       return s;
    }
}

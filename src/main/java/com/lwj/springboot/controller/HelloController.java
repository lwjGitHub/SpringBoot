package com.lwj.springboot.controller;

import com.lwj.springboot.model.Article;
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
       Article article = new Article();

       String s = "Hello Spring Boot!热部署111";
       return s;
    }
}

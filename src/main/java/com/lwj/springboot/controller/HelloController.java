package com.lwj.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author K_MAX
 * @create 2020/3/23
 */
@RestController
public class HelloController {
   @RequestMapping(value = "/hello")
    public String hello() {
       String s = "Hello Spring Boot!热部署111";
       return s;
    }
}

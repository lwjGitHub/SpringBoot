package com.lwj.springboot.jpa;

import com.lwj.springboot.dao.Article;
import com.lwj.springboot.dao.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;
    
    @Test
    public void userTest() {
        List<Article> article = articleRepository.findByAuthor("lwj");
        System.out.println(article);
    }

}

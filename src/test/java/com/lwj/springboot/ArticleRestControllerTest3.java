package com.lwj.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwj.springboot.model.Article;
import com.lwj.springboot.service.ArticleRestJDBCServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@Transactional
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Slf4j
@WebMvcTest
public class ArticleRestControllerTest3 {

    //mock对象
    @Resource
    private MockMvc mockMvc;

    @MockBean
    ArticleRestJDBCServiceImpl articleRestJDBCServiceImpl;
    //mock对象初始化
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
//    }

    //测试方法
    @Test
    public void saveArticle() throws Exception {

        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2020-03-29 21:58:00\",\n" +
                "    \"readers\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article articleObj = objectMapper.readValue(article,Article.class);

        //打桩
       when(articleRestJDBCServiceImpl.saveArticle(articleObj)).thenReturn(articleObj);

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                .contentType("application/json").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value(18))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());

    }


}
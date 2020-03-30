package com.lwj.springboot.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author K_MAX
  */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@JsonPropertyOrder(value = {"content","title"})
public class Article {

    /**
     * @since JsonIgnore //排除属性不做序列化操作
     *        JsonProperty("Author") //别名 json传参时，名称改为Author 程序才能接受到
     *        JsonPropertyOrder(value = {"content","title"}) //改变返回响应属性顺序
     *        JsonInclude(JsonInclude.Include.NON_NULL) //只包含不为空的
     *        JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 放在Date 属性上一行，有全局配置
     * */

    @JsonIgnore
    private Long id;
    @JsonProperty("author")
    private String author;
    private String title;
    private String content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private List<Reader> readers;
}

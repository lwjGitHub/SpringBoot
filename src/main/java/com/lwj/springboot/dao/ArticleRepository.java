package com.lwj.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author K_MAX
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {
    /**
     * fetch data by Author
     *
     * @param  author 作者
     *
     *
     * @return Result<AuthorDO>
     */
    List<Article> findByAuthor(String author);
}
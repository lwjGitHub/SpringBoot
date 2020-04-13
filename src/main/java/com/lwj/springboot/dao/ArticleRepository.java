package com.lwj.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author K_MAX
 */
public interface ArticleRepository extends JpaRepository<Article,Long> {
}
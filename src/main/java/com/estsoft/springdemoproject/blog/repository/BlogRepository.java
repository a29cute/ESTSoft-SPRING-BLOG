package com.estsoft.springdemoproject.blog.repository;

import com.estsoft.springdemoproject.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}

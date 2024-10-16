package com.estsoft.springdemoproject.blog.service;

import com.estsoft.springdemoproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springdemoproject.blog.domain.Article;
import com.estsoft.springdemoproject.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository repository;

    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    // blog 게시글 저장
    public Article saveArticle(AddArticleRequest request) {
        return repository.save(request.toEntity());
    }

    public List<Article> findAll() {
        List<Article> articleList = repository.findAll();
        return articleList;
    }

    // blog 게시글 단건 조회
    public Article findById(Long id) {
//        return repository.findById(id).orElseGet(Article::new);

        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found id: " + id));

    }
}

package com.estsoft.springdemoproject.blog.controller;

import com.estsoft.springdemoproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springdemoproject.blog.domain.Article;
import com.estsoft.springdemoproject.blog.domain.dto.ArticleResponse;
import com.estsoft.springdemoproject.blog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    // @RequestMapping(method = RequestMethod.POST, value = "/articles")
    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> writeArticle(@RequestBody AddArticleRequest request) {
        log.info("request: {}, {}", request.getTitle(), request.getContent());
        Article article = service.saveArticle(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(article.convert());
    }

    // request mapping 조회: http 메소드(get)
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> findAll() {
        List<ArticleResponse> list = service.findAll().stream()
                .map(article -> article.convert())
                .toList();
        return ResponseEntity.ok(list);
    }

    // 단건 조회API (Request mapping)
    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> findById(@PathVariable Long id) {
        Article article = service.findById(id); // 단건 조회
        // Article -> ArticleResponse 변환
        // ArticleResponse response = new ArticleResponse(article.getId(), article.getTitle(), article.getContent());
        return ResponseEntity.ok(article.convert());
    }


}

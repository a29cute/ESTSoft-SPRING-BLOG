package com.estsoft.springdemoproject.blog.controller;

import com.estsoft.springdemoproject.blog.domain.Article;
import com.estsoft.springdemoproject.blog.domain.dto.ArticleViewResponse;
import com.estsoft.springdemoproject.blog.service.BlogService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BlogPageController {
    private final BlogService blogService;

    public BlogPageController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/articles")
    String showArticle(Model model){ // 뷰 컨트롤러 생성

        List<Article> articleList = blogService.findAll();

        List<ArticleViewResponse> list = articleList.stream()
                .map(ArticleViewResponse::new)
                .toList();

        model.addAttribute("articles", list);
        return "articleList";
    }

}

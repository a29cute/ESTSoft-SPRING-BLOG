package com.estsoft.springdemoproject.blog.controller;

import com.estsoft.springdemoproject.blog.domain.Article;
import com.estsoft.springdemoproject.blog.domain.dto.ArticleViewResponse;
import com.estsoft.springdemoproject.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogPageController {
    private final BlogService blogService;

    public BlogPageController(BlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/articles")
        public String getArticles(Model model) {
            List<ArticleViewResponse> articles = blogService.findAll().stream()
                    .map(ArticleViewResponse::new)
                    .toList();
            model.addAttribute("articles", articles);   // model에 블로그 글 리스트 저장

            return "articleList";   // articleList.html라는 뷰 조회
        }
}

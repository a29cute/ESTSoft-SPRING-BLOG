package com.estsoft.springdemoproject.blog.controller;

import com.estsoft.springdemoproject.blog.domain.Article;
import com.estsoft.springdemoproject.blog.domain.dto.ArticleResponse;
import com.estsoft.springdemoproject.blog.domain.dto.ArticleViewResponse;
import com.estsoft.springdemoproject.blog.service.BlogService;
import com.estsoft.springdemoproject.user.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogPageController {
    private final BlogService blogService;

    public BlogPageController(BlogService blogService) {
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

    @GetMapping("/articles/{id}")
    public String showDetails(@PathVariable Long id, Model model, @AuthenticationPrincipal User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User)authentication.getPrincipal();

        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "article";
    }

    @GetMapping("/new-article")
    public String addArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) { // 새로운 게시글 생성
            model.addAttribute("article", new ArticleResponse());
        } else { // 게시글 수정
            Article article = blogService.findById(id); // 게시글 조회
            model.addAttribute("article", new ArticleViewResponse(article)); // 모델에 추가
        }
        return "newArticle";
    }

}

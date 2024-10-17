package com.estsoft.springdemoproject.blog.domain.dto;

import com.estsoft.springdemoproject.blog.domain.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;


    public ArticleViewResponse(Article article) {
            this.id = article.getId();
            this.title = article.getTitle();
            this.content = article.getContent();
            this.createdAt = article.getCreatedAt();
    }
}

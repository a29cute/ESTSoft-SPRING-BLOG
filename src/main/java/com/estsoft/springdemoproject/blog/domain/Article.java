package com.estsoft.springdemoproject.blog.domain;

import com.estsoft.springdemoproject.blog.domain.dto.ArticleResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    // 생성자
    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Article -> ArticleResponse 변환 메서드
    public ArticleResponse convert() {
        return new ArticleResponse(id, title, content);
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

package com.estsoft.springdemoproject.blog.domain;

import org.junit.jupiter.api.Test;

class ArticleConstructorTest {

    @Test
    public void test() {
        // 생성자 사용 해서 객체 생성
        Article article = new Article("제목", "내용");

        // 빌더 사용 해서 객체 생성
        Article articleBuilder = Article.builder()
                .title("제목")
                .content("내용")
                .build();
    }

}
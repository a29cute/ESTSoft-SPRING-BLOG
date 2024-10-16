package com.estsoft.springdemoproject.blog.controller;

import com.estsoft.springdemoproject.blog.domain.dto.AddArticleRequest;
import com.estsoft.springdemoproject.blog.domain.Article;
import com.estsoft.springdemoproject.blog.domain.dto.UpdateArticleRequest;
import com.estsoft.springdemoproject.blog.repository.BlogRepository;
import com.estsoft.springdemoproject.blog.service.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class BlogControllerTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BlogRepository repository;

    @Autowired
    private BlogService blogService;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        repository.deleteAll();
    }

    // POST /articles API 테스트
    @Test
    public void addArticle() throws Exception {
        // given: article 저장
        AddArticleRequest request = new AddArticleRequest("제목", "내용");

        // 직렬화  (object -> json)
        String json = objectMapper.writeValueAsString(request);

        // when: POST /articles API 호출
        ResultActions resultActions = mockMvc.perform(post("/articles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        // then: 호출 결과 검증
        resultActions.andExpect(status().isCreated())   // json
                .andExpect(jsonPath("$.title").value(request.getTitle()))
                .andExpect(jsonPath("$.content").value(request.getContent()));

        List<Article> articleList = repository.findAll();
        assertThat(articleList.size()).isEqualTo(1);
    }

    // 블로그 게시글 조회 API
    @Test
    public void findAll() throws Exception {
        // given : 조회 API에 필요한 값 세팅
        Article article = repository.save(new Article("title", "content"));

        // when : 조회 API
        ResultActions resultActions = mockMvc.perform(get("/articles")
                .accept(MediaType.APPLICATION_JSON));

        // then : API 호출 결과 검증
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value(article.getTitle()))
                .andExpect(jsonPath("$[0].content").value(article.getContent()));
    }

    // 블로그 단건 조회 API 테스트 : data insert (id = 1), GET/articles/1
    @Test
    public void findOne() throws Exception {
        // given: data insert
        Article article = repository.save(new Article("blog title", "blog content"));
        Long id = article.getId();

        // when: API 호출
        ResultActions resultActions = mockMvc.perform(get("/articles/{id}", id)
                .accept(MediaType.APPLICATION_JSON));

        // then: API 호출 결과 검증
        // -> given 절에서 추가한 데이터가 그대로 json 형태로 넘어오는지 확인
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value(article.getTitle()))
                .andExpect(jsonPath("$.content").value(article.getContent()));
    }

    // 단건 조회 API - id에 해당하는 자원이 없을 경우 (4xx) 예외처리 검증
    @Test
    public void findOneException() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/articles/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isBadRequest());

        assertThrows(IllegalArgumentException.class, () -> blogService.findById(1L));
    }

    // todo 블로그 글 삭제 API 호출 테스트
    @Test
    public void deleteTest() throws Exception {
        Article article = repository.save(new Article("blog title", "blog content"));
        Long id = article.getId();

        // when: API 호출
        ResultActions resultActions = mockMvc.perform(delete("/articles/{id}", id)
                .accept(MediaType.APPLICATION_JSON));

        // then: API 호출 결과 검증
        // -> given 절에서 추가한 데이터가 그대로 json 형태로 넘어오는지 확인
        resultActions.andExpect(status().isOk());
        List<Article> articleList = repository.findAll();
        assertThat(articleList).isEmpty();
    }

    @Test
    public void updateArticle() throws Exception {
        Article article = repository.save(new Article("blog title", "blog content"));
        Long id = article.getId();

        // 수정 데이터(object) -> json
        UpdateArticleRequest request = new UpdateArticleRequest("변경 제목", "변경 내용");
        String updateJsonContent = objectMapper.writeValueAsString(request);

        ResultActions resultActions = mockMvc.perform(put("/articles/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJsonContent)
        );

        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(request.getTitle()))
                .andExpect(jsonPath("$.content").value(request.getContent()));
    }

    // 수정API 호출시 예외 발생했을 경우(수정하려는 id 존재하지 않음) = status code 검증, Exception 검증
    @Test
    public void updateArticleException() throws Exception {
        // given : id, requestBody
        Long notExistsId = 1000L;
        UpdateArticleRequest request = new UpdateArticleRequest("title", "content");
        String requestBody = objectMapper.writeValueAsString(request);

        // when : 수정 API 호출    (/articles/{id}, requestBody)
        ResultActions resultActions = mockMvc.perform(put("/articles/{id}", notExistsId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        // then : 400 Bad Request 검증, Exception 검증
        resultActions.andExpect(status().isBadRequest());
        assertThrows(IllegalArgumentException.class, () -> blogService.update(notExistsId, request));
        assertThrows(IllegalArgumentException.class, () -> blogService.findById(notExistsId));
    }
}
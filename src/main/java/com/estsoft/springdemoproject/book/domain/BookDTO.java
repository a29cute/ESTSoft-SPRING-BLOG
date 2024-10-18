package com.estsoft.springdemoproject.book.domain;

import lombok.Getter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
public class BookDTO {
    private String id;
    private String name;
    private String author;

    public BookDTO(Book book) {
        id = book.id;
        name = book.name;
        author = book.author;
    }
}

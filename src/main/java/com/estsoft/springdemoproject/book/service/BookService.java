package com.estsoft.springdemoproject.book.service;

import com.estsoft.springdemoproject.book.domain.Book;
import com.estsoft.springdemoproject.book.repository.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll(Sort.by("id"));
    }

    public Book findByID(String id){
        return bookRepository.findById(id).orElse(new Book());
    }

    public Book saveOne(Book book){
        return bookRepository.save(book);
    }
}

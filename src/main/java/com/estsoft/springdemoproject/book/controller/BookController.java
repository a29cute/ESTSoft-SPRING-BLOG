package com.estsoft.springdemoproject.book.controller;

import com.estsoft.springdemoproject.book.domain.Book;
import com.estsoft.springdemoproject.book.domain.BookDTO;
import com.estsoft.springdemoproject.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 모든 책 정보를 보여주는 GET 메서드
    @GetMapping
    public String showAll(Model model) {
        List<BookDTO> list = bookService.findAll()
                .stream()
                .map(BookDTO::new)
                .toList();

        model.addAttribute("bookList", list);
        return "bookManagement";
    }

    // 특정 책 정보를 보여주는 GET 메서드
    @GetMapping("/{id}")
    public String showOne(@PathVariable String id, Model model) {
        Book book = bookService.findByID(id);
        model.addAttribute(id);
        model.addAttribute("book", new BookDTO(book));
        return "bookDetail";
    }

    // 새로운 책 정보를 저장하는 POST 메서드 추가
    @PostMapping("/add")
    public String addBook(@RequestParam String id,
                          @RequestParam String name,
                          @RequestParam String author) {

        // 새 책 정보를 저장
        bookService.saveOne(new Book(id, name, author));

        // 책 목록 페이지로 리다이렉트
        return "redirect:/books";
    }

}

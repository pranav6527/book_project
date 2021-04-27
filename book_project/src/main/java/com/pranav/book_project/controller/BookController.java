package com.pranav.book_project.controller;

import com.pranav.book_project.entity.Book;
import com.pranav.book_project.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/book")
public class BookController {

  @Autowired private BookService bookService;

  @GetMapping("/all-books")
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @PostMapping("/save-book")
  public ResponseEntity<Book> saveBook(@RequestBody Book book) {
    Book savedBook = bookService.saveBook(book);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
  }
}

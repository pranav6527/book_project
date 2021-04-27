package com.pranav.book_project.service;

import com.pranav.book_project.entity.Book;
import com.pranav.book_project.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired private BookRepository bookRepository;

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }
}

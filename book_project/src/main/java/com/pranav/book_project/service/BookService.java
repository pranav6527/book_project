package com.pranav.book_project.service;

import com.pranav.book_project.entity.Book;
import com.pranav.book_project.repository.BookRepository;
import com.pranav.book_project.util.helper.ExcelHelper;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookService {

  @Autowired private BookRepository bookRepository;

  public  Page<Book> findAll(Pageable pagingSort) {
    return  bookRepository.findAll(pagingSort);
  }

  public List<Book> getAllBooks() {

    return bookRepository.findAll().stream().filter(book -> null!= book.getName()).sorted((Comparator
        .comparing(Book::getName,String::compareToIgnoreCase))).collect(
        Collectors.toList());
  }

  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }

  public void uploadBook(MultipartFile file) {
    try {
      List<Book> books = ExcelHelper.excelToBooks(file.getInputStream());
      bookRepository.saveAll(books);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public Optional<Book> findBookByName(String name) {
    return bookRepository.findByBook_name(name);
  }
}

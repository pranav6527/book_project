package com.pranav.book_project.service;

import com.pranav.book_project.entity.Book;
import com.pranav.book_project.repository.BookRepository;
import com.pranav.book_project.util.helper.ExcelHelper;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookService {

  @Autowired private BookRepository bookRepository;

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
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
}

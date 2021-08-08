package com.pranav.book_project.controller;

import com.pranav.book_project.dto.ResponseMessage;
import com.pranav.book_project.entity.Book;
import com.pranav.book_project.exception.BookNotFoundException;
import com.pranav.book_project.service.BookService;
import com.pranav.book_project.util.helper.ExcelHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping("/all-books")
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @PostMapping("/save-book")
  //@PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<ResponseMessage> saveBook(@RequestBody Book book) {
    String message = "";
    if (null != book) {
      Book savedBook = bookService.saveBook(book);
      message = "Book saved Successfully:";
      return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));
    } else {
      message = "Unable to save Book";
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }

  }

  @PostMapping("/upload-books")
//  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (ExcelHelper.hasExcelFormat(file)) {
      try {
        bookService.uploadBook(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
            .body(new ResponseMessage(message));
      }
    }
    message = "Please upload an excel file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

  @GetMapping("/find-book/{name}")
  public ResponseEntity<Book> getBookByName(@PathVariable("name") String name)
      throws BookNotFoundException {
    Optional<Book> book = bookService.findBookByName(name);
    if (book.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(book.get());
    } else {
      throw new BookNotFoundException();
    }
  }

  @GetMapping("/book-by-page")
  public ResponseEntity<Map<String, Object>> getBooksByPage(
      @RequestParam(required = false) String title,
        @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "3") int size
  ) {
    try {

      List<Book> books = new ArrayList<>();
      Pageable pagingSort = PageRequest.of(page, size, Sort.by("name"));
      Page<Book> pageBook;

      pageBook = bookService.findAll(pagingSort);

      books = pageBook.getContent();

      Map<String, Object> response = new HashMap<>();
      response.put("books", books);
      response.put("currentPage", pageBook.getNumber());
      response.put("totalItems", pageBook.getTotalElements());
      response.put("totalPages", pageBook.getTotalPages());

      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      log.error(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
}

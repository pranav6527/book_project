package com.pranav.book_project.controller;

import com.pranav.book_project.dto.ResponseMessage;
import com.pranav.book_project.entity.Book;
import com.pranav.book_project.service.BookService;
//import com.pranav.book_project.util.helper.ExcelHelper;
import com.pranav.book_project.util.helper.ExcelHelper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
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
    if(null!=book) {
      Book savedBook = bookService.saveBook(book);
      message = "Book saved Successfully:";
      return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));
    }
    else
    {
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
}

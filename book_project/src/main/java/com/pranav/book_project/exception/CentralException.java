package com.pranav.book_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralException {

  @ExceptionHandler(BookNotFoundException.class)
  public ResponseEntity<Object> bookNotFoundException(BookNotFoundException ex)
  {
      return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
  }

}

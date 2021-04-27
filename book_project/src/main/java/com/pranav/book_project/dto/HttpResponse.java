package com.pranav.book_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class HttpResponse {

  private int httpStatusCode;
  private HttpStatus httpStatus;
  private String meesage;
  private String reason;
}

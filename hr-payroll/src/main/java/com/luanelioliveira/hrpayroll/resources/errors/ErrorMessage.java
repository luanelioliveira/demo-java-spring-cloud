package com.luanelioliveira.hrpayroll.resources.errors;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorMessage {

  private String message;
  private HttpStatus status;
  private LocalDateTime timestamp;

  public static ErrorMessage of(String message, HttpStatus status) {
    return new ErrorMessage(message, status, LocalDateTime.now());
  }
}

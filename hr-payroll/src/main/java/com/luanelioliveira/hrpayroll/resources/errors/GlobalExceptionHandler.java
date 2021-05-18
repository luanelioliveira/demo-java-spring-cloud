package com.luanelioliveira.hrpayroll.resources.errors;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<ErrorMessage> handleNoSuchElement(NoSuchElementException e) {

    var error = ErrorMessage.of(e.getMessage(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(error, error.getStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> handleDefaultError(Exception e) {

    var error = ErrorMessage.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(error, error.getStatus());
  }
}

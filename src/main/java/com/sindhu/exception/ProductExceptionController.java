package com.sindhu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
   @ExceptionHandler(value = ProductNotfoundException.class)
   public ResponseEntity<Object> exception(ProductNotfoundException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(value = ProductAlreadyExistsException.class)
   public ResponseEntity<Object> ProductAlreadyExistsException(ProductNotfoundException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
   }
}
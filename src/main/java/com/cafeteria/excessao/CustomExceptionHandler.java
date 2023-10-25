package com.cafeteria.excessao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	 @ExceptionHandler(ProdutoNotFoundException.class)
	 public ResponseEntity<String> handleProdutoNotFoundException(ProdutoNotFoundException produtoNotFoundException){
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(produtoNotFoundException.getMessage());
	 }
	 
		 
	 

}

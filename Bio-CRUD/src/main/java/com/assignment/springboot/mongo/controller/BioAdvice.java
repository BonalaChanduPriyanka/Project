package com.assignment.springboot.mongo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.springboot.mongo.exceptions.BioException;

@RestControllerAdvice
public class BioAdvice {
	@ExceptionHandler(value = {BioException.class})
	
	public ResponseEntity<String> Exception1(BioException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}

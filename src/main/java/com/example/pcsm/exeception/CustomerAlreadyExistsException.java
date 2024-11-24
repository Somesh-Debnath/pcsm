package com.example.ctsproject.exeception;
public class CustomerAlreadyExistsException extends RuntimeException {
	   public CustomerAlreadyExistsException(String message) {
	       super(message);
	   }
	}
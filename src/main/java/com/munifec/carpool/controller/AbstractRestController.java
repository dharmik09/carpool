package com.munifec.carpool.controller;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.munifec.carpool.model.ErrorDetails;
import com.munifec.carpool.service.CounterService;

public class AbstractRestController{
	
	@Autowired
	CounterService counterService;
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<ErrorDetails> handleException(NoSuchElementException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false), HttpStatus.NO_CONTENT.toString());
		return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public ResponseEntity<ErrorDetails> handleException(IllegalArgumentException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false), HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
	  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR.toString());
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	protected String getUserNameForLoggedInUser(){
		//TODO CHANGE LATER WITH LOGGED IN USER ACTUAL NAME
		return "system";
	}
	
	protected long getIdForNewObject(String constantForClass) {
		return counterService.getNexId(constantForClass);
	}
}

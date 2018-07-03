package com.munifec.carpool.controller;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.munifec.carpool.constants.MessageConstants;
import com.munifec.carpool.response.CarpoolResponse;
import com.munifec.carpool.service.CounterService;

public class AbstractRestController{
	
	@Autowired
	CounterService counterService;
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public CarpoolResponse handleException(NoSuchElementException ex, WebRequest request){
		return new CarpoolResponse(0, MessageConstants.MSG_FAILURE_GET, new HashMap<String,Object>(), new HashMap<String,Object>());
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public CarpoolResponse handleException(IllegalArgumentException ex, WebRequest request){
		return new CarpoolResponse(0, MessageConstants.MSG_FAILURE_GET, new HashMap<String,Object>(), new HashMap<String,Object>());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public final CarpoolResponse handleAllExceptions(Exception ex, WebRequest request) {		
		return new CarpoolResponse(0, ex.getMessage(), new HashMap<String,Object>(), new HashMap<String,Object>());
	}
	
	protected String getUserNameForLoggedInUser(){
		//TODO CHANGE LATER WITH LOGGED IN USER ACTUAL NAME
		return "system";
	}
	
	protected long getIdForNewObject(String constantForClass) {
		return counterService.getNexId(constantForClass);
	}
}

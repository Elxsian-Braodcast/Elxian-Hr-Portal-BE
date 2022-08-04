package com.tataelxsi.webservices.rest.Controller;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tataelxsi.webservices.rest.exception.ResourceNotFound;
import com.tataelxsi.webservices.rest.exception.ResponseException;

@RestController
@ControllerAdvice

// used for collabrate all controllers for one structure of code
public class CustomizedExceptionController extends ResponseEntityExceptionHandler {
	
   @ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleALLException(Exception ex, WebRequest request) throws Exception {
		ResponseException allExceptions = new ResponseException(new Date(0), ex.getMessage(),
				request.getDescription(true));
		return new ResponseEntity<Object>(allExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
	}
   
   @ExceptionHandler(ResourceNotFound.class)
  	public final ResponseEntity<Object> handleResourceException(Exception ex, WebRequest request) throws Exception {
  		ResponseException allExceptions = new ResponseException(new Date(0), ex.getMessage(),
  				request.getDescription(false));
  		return new ResponseEntity<Object>(allExceptions, HttpStatus.NOT_FOUND);
  	}
   
   

}

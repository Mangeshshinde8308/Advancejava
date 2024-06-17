package com.RESTAPIapp.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
	
@ExceptionHandler(CustomException.class)
public ResponseEntity<String> handleEmptyInput (CustomException ustomException){
	return new ResponseEntity<String>("Empty name provided",HttpStatus.BAD_REQUEST);
	
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noElementException){
	return new ResponseEntity<String>("No id present in DB",HttpStatus.NOT_FOUND);
	
}

@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
	return new ResponseEntity<Object>("change request ",HttpStatus.BAD_REQUEST);	}
	


}

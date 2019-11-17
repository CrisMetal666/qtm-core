package com.jmtm.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jmtm.exception.YaExisteEntityException;
import com.jmtm.model.dto.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		
		ExceptionResponse object = new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(object, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(YaExisteEntityException.class)
	public final ResponseEntity<Object> handleNotFoundException(YaExisteEntityException ex, WebRequest request) {
		
		ExceptionResponse object = new ExceptionResponse(LocalDate.now(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(object, HttpStatus.BAD_REQUEST);
	}
}

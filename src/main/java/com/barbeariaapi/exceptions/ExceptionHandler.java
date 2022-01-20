package com.barbeariaapi.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Erro> erros = listaErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
	protected ResponseEntity<Object> handleBusinessException(Exception ex, WebRequest request) {
	
		String message = ex.getMessage();
		String front = "Usuário já existente";
		return handleExceptionInternal(ex, new Erro(front, message), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
//	@org.springframework.web.bind.annotation.ExceptionHandler({NonUniqueResultException.class})
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public void handleNonUniqueResultException(RuntimeException ex) {
//		
//	}
	
//	@org.springframework.web.bind.annotation.ExceptionHandler({EmptyResultDataAccessException.class})
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public ResponseEntity<Object> handleEmptyResultDataAccessException(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//
//		return handleExceptionInternal(ex, "Usuário já existe", headers, HttpStatus.BAD_REQUEST, request);
//	}
	
	private List<Erro> listaErros(BindingResult bindingResult){
		List<Erro> erros = new ArrayList<>();
		for(FieldError fieldError: bindingResult.getFieldErrors()) {
			String field = fieldError.getField();
			String font = field + " "+ messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String message = fieldError.toString();
			erros.add(new Erro(font, message));
		}
		return erros;
	}
	
	
	public static class Erro{
		
		private String front;
		private String message;
		
		public String getFront() {
			return front;
		}
		public void setFront(String front) {
			this.front = front;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		public Erro(String front, String message) {
			super();
			this.front = front;
			this.message = message;
		}
		public Erro() {
			super();
		}
	}
}

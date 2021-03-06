package com.monitora.monitoralog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.monitora.monitoralog.domain.exception.DomainException;
import com.monitora.monitoralog.domain.exception.EntidadeNaoEncontrada;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		List<Erro.CampoErro> campos = new ArrayList<>();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			campos.add(new Erro.CampoErro(nome, message));
		}
		
		Erro erro = new Erro();
		erro.setStatus(status.value());
		erro.setDataHora(OffsetDateTime.now());
		erro.setTitulo("Um ou mais campos estão inválidos. Façao preenchimento correto e tente novamente.");
		erro.setCampos(campos);
				
		return handleExceptionInternal(ex, erro, headers, status, request);
	}
	
	@ExceptionHandler(EntidadeNaoEncontrada.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontrada(EntidadeNaoEncontrada ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Erro erro = new Erro();
		erro.setStatus(status.value());
		erro.setDataHora(OffsetDateTime.now());
		erro.setTitulo(ex.getMessage());
		
		return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Erro erro = new Erro();
		erro.setStatus(status.value());
		erro.setDataHora(OffsetDateTime.now());
		erro.setTitulo(ex.getMessage());
		
		return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}
}

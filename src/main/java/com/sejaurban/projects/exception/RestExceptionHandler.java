package com.sejaurban.projects.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UnauthorizedChangeStateException.class)
	protected ResponseEntity<Object> handleUnauthorizedChangeState() {
		String message = "Mudança de estado não autorizado.";
		return buildResponseEntity(new GenericException(HttpStatus.UNAUTHORIZED, message));
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> handleUserNotFound() {
		String message = "Usuário não encontrado.";
		return buildResponseEntity(new GenericException(HttpStatus.NOT_FOUND, message));
	}
	
	@ExceptionHandler(ProjectNotFoundException.class)
	protected ResponseEntity<Object> handleProjectNotFound() {
		String message = "Projeto não encontrado.";
		return buildResponseEntity(new GenericException(HttpStatus.NOT_FOUND, message));
	}
	
	@ExceptionHandler(StatusNotFoundException.class)
	protected ResponseEntity<Object> handleStatusNotFound() {
		String message = "Status não encontrado.";
		return buildResponseEntity(new GenericException(HttpStatus.NOT_FOUND, message));
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	protected ResponseEntity<Object> handleUnauthorized() {
		String error = "Não autorizado. Tente realizar o login novamente.";
		return buildResponseEntity(new GenericException(HttpStatus.UNAUTHORIZED, error));
	}
	
	@ExceptionHandler(WrongCredentialsException.class)
	protected ResponseEntity<Object> handleWrongCredentials() {
		String error = "Falha na autenticação. Verifique suas credenciais e tente novamente.";
		return buildResponseEntity(new GenericException(HttpStatus.UNAUTHORIZED, error));
	}
	
	private ResponseEntity<Object> buildResponseEntity(GenericException genericException) {
		return new ResponseEntity<>(genericException, genericException.getStatusText());
	}
}

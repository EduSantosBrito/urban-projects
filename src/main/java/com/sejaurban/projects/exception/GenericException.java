package com.sejaurban.projects.exception;

import org.springframework.http.HttpStatus;

public class GenericException {
	
	private String message;
	private HttpStatus statusText;
	private Integer status;	

	public GenericException(HttpStatus statusText, String message) {
		this.statusText = statusText;
		this.message = message;
		this.status = statusText.value();
	}
	
	public String getMessage() {
		return message;
	}

	public HttpStatus getStatusText() {
		return statusText;
	}

	public Integer getStatus() {
		return status;
	}
	
	

}

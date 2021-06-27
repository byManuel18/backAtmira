package com.example.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UnselectedPlanetException extends RuntimeException{
	private String exceptionDetail;
	
	public UnselectedPlanetException(String exceptionDetail) {
		super(exceptionDetail);
		this.exceptionDetail=exceptionDetail;
	}
	
	public String getExceptionDetail() {
		return exceptionDetail;
	}
}

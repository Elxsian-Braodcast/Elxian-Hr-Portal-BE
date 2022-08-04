package com.tataelxsi.webservices.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

	public ResourceNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

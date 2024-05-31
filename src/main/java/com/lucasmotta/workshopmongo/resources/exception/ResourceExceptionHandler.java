package com.lucasmotta.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.lucasmotta.workshopmongo.services.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException obj, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError(System.currentTimeMillis(), status.value(), "Não encontrado", obj.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}

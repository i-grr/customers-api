package io.github.i_grr.customers.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import io.github.i_grr.customers.rest.exceptions.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleValidationErrors(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		List<String> messages = bindingResult.getAllErrors()
			.stream()
			.map(objectError -> objectError.getDefaultMessage())
			.collect(Collectors.toList());
		return new ApiErrors(messages);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusException(ResponseStatusException e) {
		String messageError = e.getMessage();
		HttpStatus statusCode = e.getStatus();
		ApiErrors apiErrors = new ApiErrors(messageError);
		return new ResponseEntity(apiErrors, statusCode);
	}
	
}

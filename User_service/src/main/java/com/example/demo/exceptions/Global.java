package com.example.demo.exceptions;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

//@RestControllerAdvice
public class Global extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		ErrorDetails errorDetails = new ErrorDetails(new Date(System.currentTimeMillis()), "Method not supported.",
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.METHOD_NOT_ALLOWED);
	}

	

	/// validation annotations (like @NotBlank, @Size, @Email, etc.) fail on the
	/// fields in a request body. To handle this
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	/// this is for if unique constraint violated or in general attempt to execute
		/// an SQL statement fails
		@ExceptionHandler(DataIntegrityViolationException.class)
		public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
				WebRequest request) {
			Map<String, String> errors = new HashMap<>();

			// Checking if the error message contains 'email' to return a custom message for
			// duplicate email
			if (ex.getMessage().contains("email")) {
				errors.put("email", "Email already exists");
			} else {
				errors.put("error", "You have entered duplicate entry. Please check your input.");
			}

			return new ResponseEntity<>(errors, HttpStatus.CONFLICT);
		}
}

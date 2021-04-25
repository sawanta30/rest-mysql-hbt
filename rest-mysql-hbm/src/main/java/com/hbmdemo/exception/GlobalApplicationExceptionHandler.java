package com.hbmdemo.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class GlobalApplicationExceptionHandler {

	@ExceptionHandler(value = {Exception.class })
	public ResponseEntity<GenericResponse> handleException(Exception exception) {
		GenericResponse er = new GenericResponse(exception.getMessage());
		return new ResponseEntity<GlobalApplicationExceptionHandler.GenericResponse>(er, new HttpHeaders(),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {EmployeeNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
		ErrorResponse er = new ErrorResponse(exception.getErrorCode(), exception.getMessage(), exception.getDescription()+" : "+exception.getEid(),ZonedDateTime.now());
		return new ResponseEntity<GlobalApplicationExceptionHandler.ErrorResponse>(er, new HttpHeaders(),
				HttpStatus.BAD_REQUEST);
	}
	
	

	class ErrorResponse {
		int errorCode;
		String message;
		String description;
		ZonedDateTime timestamp;

		

		public ErrorResponse(int errorCode, String message, String description, ZonedDateTime timestamp) {
			this.errorCode = errorCode;
			this.message = message;
			this.description = description;
			this.timestamp = timestamp;
		}

		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public ZonedDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(ZonedDateTime timestamp) {
			this.timestamp = timestamp;
		}
		
		

	}
	class GenericResponse{
		String messgae;
		
		

		public GenericResponse(String messgae) {
			this.messgae = messgae;
		}

		public String getMessgae() {
			return messgae;
		}

		public void setMessgae(String messgae) {
			this.messgae = messgae;
		}
		
	}
	

}

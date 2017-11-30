package uk.gov.digital.ho.egar.shared.util.controller.advice;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages="uk.gov.digital.ho.egar")
public class SharedControllerAdvice {
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(AuthenticationServiceException.class)
	public void handleAccessDeniedException() {
		
	}
	
	// Not found
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EntityNotFoundException.class)
	public void handleIDNotFoundException() {
		
	}
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public void handleEntityNotFoundException() {
		
	}
}

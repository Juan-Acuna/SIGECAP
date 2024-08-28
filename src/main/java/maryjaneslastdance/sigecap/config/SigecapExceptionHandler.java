package maryjaneslastdance.sigecap.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import maryjaneslastdance.sigecap.exception.InactiveUserException;

@ControllerAdvice
public class SigecapExceptionHandler {
	
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException e){
		return new ResponseEntity<>("Error de usuario:" + e.getMessage() ,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InactiveUserException.class)
	public ResponseEntity<String> handleInactiveUserException(InactiveUserException e){
		return new ResponseEntity<>("Error de usuario:" + e.getMessage() ,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException e){//
		return new ResponseEntity<>("Error de usuario: Credenciales inválidas" ,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		e.printStackTrace();
		return new ResponseEntity<>("Error interno:" + e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

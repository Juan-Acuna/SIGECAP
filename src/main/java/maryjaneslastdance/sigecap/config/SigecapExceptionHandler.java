package maryjaneslastdance.sigecap.config;

import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
		return new ResponseEntity<>("{\"error\":\"Error de usuario:" + e.getMessage() + "\"}" ,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InactiveUserException.class)
	public ResponseEntity<String> handleInactiveUserException(InactiveUserException e){
		return new ResponseEntity<>("{\"error\":\"Error de usuario:" + e.getMessage() + "\"}" ,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException e){//
		return new ResponseEntity<>("{\"error\": \"Error de usuario: Credenciales inválidas\"}" ,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SignatureException.class)
	public ResponseEntity<String> handleSignatureException(SignatureException e, HttpServletResponse response){//
		Cookie cookie = new Cookie("token", null);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return new ResponseEntity<>("{\"error\": \"Error de usuario: Token invalido\"}" ,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception e){
		System.out.println(e.getMessage());
		return new ResponseEntity<>("{\"error\": \"Error interno:" + e.getMessage() + "\"}" ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

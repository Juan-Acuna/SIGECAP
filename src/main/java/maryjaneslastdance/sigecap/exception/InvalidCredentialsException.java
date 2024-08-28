package maryjaneslastdance.sigecap.exception;

@SuppressWarnings("serial")
public class InvalidCredentialsException extends RuntimeException{
	public InvalidCredentialsException(String msg) {
		super(msg);
	}
}

package maryjaneslastdance.sigecap.exception;

@SuppressWarnings("serial")
public class InactiveUserException extends RuntimeException{
	public InactiveUserException(String msg) {
		super(msg);
	}
}

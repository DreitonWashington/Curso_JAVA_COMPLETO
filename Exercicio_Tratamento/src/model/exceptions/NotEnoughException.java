package model.exceptions;

public class NotEnoughException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public NotEnoughException(String msg) {
		super(msg);
	}
}

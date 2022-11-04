package model.exceptions;

public class ZeroBalanceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ZeroBalanceException(String msg) {
		super(msg);
	}
	
}

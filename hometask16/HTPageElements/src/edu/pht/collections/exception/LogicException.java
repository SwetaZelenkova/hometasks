package edu.pht.collections.exception;

public class LogicException extends Exception {
	
	private String detail;

	public LogicException(String detail) {
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}
	
	@Override
	public String getMessage() {
		return " LogicException -> " + detail;
	}

	@Override
	public String toString() {
		return " LogicException | detail = " + detail + " | ";
	}
	
}

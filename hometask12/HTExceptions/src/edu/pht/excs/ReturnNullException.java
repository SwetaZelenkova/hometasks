package edu.pht.excs;

public class ReturnNullException extends Exception {
	
	private String detail;

	public ReturnNullException(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "ReturnNullException [detail=" + detail + "]";
	}

	@Override
	public String getMessage() {
		return "ReturnNullException [detail=" + detail + "]";
	}
}

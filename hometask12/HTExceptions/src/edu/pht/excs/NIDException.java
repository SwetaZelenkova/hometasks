package edu.pht.excs;

public class NIDException extends Exception {

	private String detail;

	public NIDException() {
	}

	public NIDException(String message, Throwable cause) {
		super(message, cause);
	}

	public NIDException(String message, String detail) {
		super(message);
		this.detail = detail;
	}

	public NIDException(Throwable cause) {
		super(cause);
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "NIDException [detail=" + detail + "]";
	}

	@Override
	public String getMessage() {
		return super.getMessage() + "NIDException [detail=" + detail + "]";
	}

}

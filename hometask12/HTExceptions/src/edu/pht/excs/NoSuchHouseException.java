package edu.pht.excs;

public class NoSuchHouseException extends Exception {

	private String detail;

	public NoSuchHouseException(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "NoSuchHouseException [detail=" + detail + "]";
	}

	@Override
	public String getMessage() {
		return "NoSuchHouseException [detail=" + detail + "]";
	}

}

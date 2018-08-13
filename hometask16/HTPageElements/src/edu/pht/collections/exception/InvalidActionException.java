package edu.pht.collections.exception;

public class InvalidActionException extends LogicException {

	private String resume;
	
	public InvalidActionException(String detail) {
		super(detail);
	}

	public InvalidActionException(String detail, String resume) {
		super(detail);
		this.resume = resume;
	}

	@Override
	public String getMessage() {
		return " InvalidActionException -> " + super.getMessage() + " -> " + resume;
	}

	@Override
	public String toString() {
		return " InvalidActionException [resume=" + resume + ", getDetail()=" + getDetail() + "]";
	}
}

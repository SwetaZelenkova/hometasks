package edu.pht.collections.exception;

public class NoSuchEntityException extends LogicException {

	private String resume;

	public NoSuchEntityException(String detail) {
		super(detail);
	}

	public NoSuchEntityException(String detail, String resume) {
		super(detail);
		this.resume = resume;
	}

	@Override
	public String getMessage() {
		return " NoSuchEntityException -> " + super.getMessage() + " -> " + resume;
	}

	@Override
	public String toString() {
		return " NoSuchEntityException [resume=" + resume + ", getDetail()=" + getDetail() + "]";
	}

}

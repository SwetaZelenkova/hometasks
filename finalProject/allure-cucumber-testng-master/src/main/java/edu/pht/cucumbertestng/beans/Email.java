package edu.pht.cucumbertestng.beans;

public class Email {

	private int id;
	private String email;
	private String moreEmails;
	private String subject;
	private String body;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMoreEmails() {
		return moreEmails;
	}

	public void setMoreEmails(String moreEmails) {
		this.moreEmails = moreEmails;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", email=" + email + ", moreEmails=" + moreEmails + ", subject=" + subject
				+ ", body=" + body + "]";
	}
}

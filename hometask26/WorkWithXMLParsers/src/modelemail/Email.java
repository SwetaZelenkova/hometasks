package modelemail;

public class Email {

	private int id;
	private String messageToReceiver;
	private String copyTo;
	private String subject;
	private String body;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessageToReceiver() {
		return messageToReceiver;
	}

	public void setMessageToReceiver(String messageToReceiver) {
		this.messageToReceiver = messageToReceiver;
	}

	public String getCopyTo() {
		return copyTo;
	}

	public void setCopyTo(String copyTo) {
		this.copyTo = copyTo;
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
		return "Email: id=" + id + ", messageToReceiver=" + messageToReceiver + ", copyTo=" + copyTo + ", subject="
				+ subject + ", body=" + body;
	}

}

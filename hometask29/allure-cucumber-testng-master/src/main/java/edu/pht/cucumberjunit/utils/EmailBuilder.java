package edu.pht.cucumberjunit.utils;

import edu.pht.cucumberjunit.beans.Email;

public abstract class EmailBuilder {

	Email emailObj;

	public void createEmail() {
		emailObj = new Email();
	}

	public abstract void buildEmail();

	public abstract void buildmoreEmails();

	public abstract void buildSubject();

	public abstract void buildBody();

	public Email getEmail() {
		return emailObj;
	}

}

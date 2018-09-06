package edu.pht.cucumberjunit.utils;

import edu.pht.cucumberjunit.beans.Email;

public class Director {

	private EmailBuilder builder;

	public void setBuilder(EmailBuilder builder) {
		this.builder = builder;
	}

	public Email buildEmail() {

		builder.createEmail();
		builder.buildEmail();
		builder.buildmoreEmails();
		builder.buildSubject();
		builder.buildBody();

		Email email = builder.getEmail();
		return email;
	}
}

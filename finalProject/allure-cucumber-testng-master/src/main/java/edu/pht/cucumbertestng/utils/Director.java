package edu.pht.cucumbertestng.utils;

import edu.pht.cucumbertestng.beans.Email;

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

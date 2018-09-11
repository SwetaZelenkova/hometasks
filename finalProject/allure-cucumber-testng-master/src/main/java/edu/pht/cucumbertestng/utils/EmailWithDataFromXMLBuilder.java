package edu.pht.cucumbertestng.utils;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import edu.pht.cucumbertestng.beans.Email;

public class EmailWithDataFromXMLBuilder extends EmailBuilder {

	private static final Logger logger = Logger.getLogger(EmailWithDataFromXMLBuilder.class);
	private static final String EMAILS_XML = "emails.xml";
	private int id;
	private String email;
	private String moreEmails;
	private String subject;
	private String body;

	public EmailWithDataFromXMLBuilder() {
	}

	public EmailWithDataFromXMLBuilder init(int id) {
		List<Email> emails = null;
		DocumentBuilder dBuilder;
		Document document;
		try {
			dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			document = dBuilder.parse(EMAILS_XML);
			emails = new DomParser().parse(document);
			logger.info("DomParser parsing XML finished.....");
		} catch (SAXException | IOException | XMLStreamException | ParserConfigurationException e) {
			logger.error("dom..parsing..error.....", e);
		}
		for (int i = 0; i < emails.size(); i++) {
			if (emails.get(i).getId() == id) {
				this.id = emails.get(i).getId();
				email = emails.get(i).getEmail();
				moreEmails = emails.get(i).getMoreEmails();
				subject = emails.get(i).getSubject();
				body = emails.get(i).getBody();
			}
		}
		return this;
	}

	@Override
	public void buildEmail() {
		emailObj.setEmail(email);
	}

	@Override
	public void buildmoreEmails() {
		emailObj.setMoreEmails(moreEmails);
	}

	@Override
	public void buildSubject() {
		emailObj.setSubject(subject);
	}

	@Override
	public void buildBody() {
		emailObj.setBody(body);
	}
}

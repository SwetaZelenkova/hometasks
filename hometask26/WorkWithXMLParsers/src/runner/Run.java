package runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import domparser.DomParser;
import modelemail.Email;
import saxparser.EmailHandler;
import staxparser.StaxParser;

public class Run {

	private static final String EMAILS_XML = "emails.xml";

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		System.out.println(" ========================= SAX parser ==============================");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		EmailHandler emailHandler = new EmailHandler();
		saxParser.parse(new File(EMAILS_XML), emailHandler);
		List<Email> emails = emailHandler.getEmails();
		emails.forEach(email -> System.out.println(email));
		
		System.out.println(" ============================== STAX parser =========================");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(EMAILS_XML));
        emails = new StaxParser().parse(xmlEventReader);
        emails.forEach(email -> System.out.println(email));

		System.out.println(" ============================== DOM parser =========================");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(EMAILS_XML);
		emails = new DomParser().parse(document);
		emails.forEach(email -> System.out.println(email));
	}
}


package domparser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import modelemail.Email;

public class DomParser {

	public List<Email> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("email");
		List<Email> emails = new ArrayList<>();
		String id;
		for (int i = 0; i < nodeList.getLength(); i++) {
			id = nodeList.item(i).getAttributes().item(0).getTextContent();
			emails.add(getEmail(nodeList.item(i), id));
		}
		return emails;
	}

	private Email getEmail(Node node, String id) {
		Email email = new Email();
		Element element = (Element) node;
		email.setId(Integer.parseInt(id));
		email.setMessageToReceiver(getTagValue("messageToReceiver", element));
		email.setCopyTo(getTagValue("copyTo", element));
		email.setSubject(getTagValue("subject", element));
		email.setBody(getTagValue("body", element));
		return email;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}

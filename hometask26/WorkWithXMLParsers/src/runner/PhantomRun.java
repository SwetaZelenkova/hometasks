package runner;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PhantomRun {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File("emails.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();

		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("email");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			NamedNodeMap mapWithAttr = nNode.getAttributes();
			if (mapWithAttr.getLength() != 0) {
				System.out.println("\nCurrent Element: " + nNode.getNodeName() + " with id = "
						+ mapWithAttr.item(0).getTextContent());
				System.out.println();
			}

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				System.out.println("Details: " + eElement.getTextContent());
			}
		}
	}
}

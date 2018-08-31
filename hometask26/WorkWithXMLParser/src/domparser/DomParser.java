package domparser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Country;

public class DomParser {

	public List<Country> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("Country");
		List<Country> countries = new ArrayList<>();
		String id;
		for (int i = 0; i < nodeList.getLength(); i++) {
			id = nodeList.item(i).getAttributes().item(0).getTextContent();
			countries.add(getCountry(nodeList.item(i), id));
		}
		return countries;
	}

	private Country getCountry(Node node, String id) {
		Country country = new Country();
		Element element = (Element) node;
		country.setId(Integer.parseInt(id));
		country.setCode(getTagValue("Code", element));
		country.setName(getTagValue("Name", element));
		country.setDescription(getTagValue("Description", element));
		country.setPopulation(Double.parseDouble(getTagValue("Population", element)));
		return country;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}

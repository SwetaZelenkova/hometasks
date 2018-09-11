package edu.pht.cucumbertestng.restapi;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.pht.cucumbertestng.beans.ProfileInfo;

public class DomParserResponse {

	public ProfileInfo parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("response");
		ProfileInfo resp = getProfileInfo(nodeList.item(0));
		return resp;
	}

	private ProfileInfo getProfileInfo(Node node) {
		ProfileInfo response = new ProfileInfo();
		Element element = (Element) node;
		response.setBdate_visibility(Integer.parseInt(getTagValue("bdate_visibility", element)));
		response.setHome_town(getTagValue("home_town", element));
		response.setStatus(getTagValue("status", element));
		return response;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}
}

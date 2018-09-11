package edu.pht.cucumbertestng.restapisteps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.pht.cucumbertestng.beans.ProfileInfo;
import edu.pht.cucumbertestng.restapi.DomParserResponse;


public class ProfileInfoWithRESTAPISteps {
	
	private static final Logger logger = Logger.getLogger(ProfileInfoWithRESTAPISteps.class);
	private HttpResponse response;

	public ProfileInfoWithRESTAPISteps() {
	}

	@Given("^I want to save my profile info vk.com: bdate_visibility (\\d+), home_town \"([^\"]*)\", status \"([^\"]*)\"$")
	public void saveProfileInfo(int bdateVisibility, String homeTown, String status) throws URISyntaxException, ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/account.saveProfileInfo.xml?");
        builder.setParameter("access_token", "40853f1a4bf0513e5ea1d32b36d865318886d350fd458871bcf280b35b4194fd62ca150adc0358f37271e")
        .setParameter("status", status)
        .setParameter("home_town", homeTown)
        .setParameter("bdate_visibility", String.valueOf(bdateVisibility))
        .setParameter("v", "5.73");
        
        HttpGet request = new HttpGet(builder.build());
        response = client.execute(request);
        logger.info("Save profile info: " + bdateVisibility + ", " + homeTown + ", " + status);
	}

	@When("^I get my profile info vk.com$")
	public void getProfileInfo() throws URISyntaxException, ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("https://api.vk.com/method/account.getProfileInfo.xml?");
        builder.setParameter("access_token", "40853f1a4bf0513e5ea1d32b36d865318886d350fd458871bcf280b35b4194fd62ca150adc0358f37271e")
        .setParameter("v", "5.73");
        
        HttpGet request = new HttpGet(builder.build());
        response = client.execute(request);
        logger.info("Get profile info");
	}

	@Then("^I validate the saving Info and getting Info$")
	public void validateProfileInfo() throws ParserConfigurationException, UnsupportedOperationException, SAXException, IOException, XMLStreamException {
		ProfileInfo actual;
		ProfileInfo expected = new ProfileInfo();
		expected.setBdate_visibility(2);
		expected.setHome_town("8888877777");
		expected.setStatus("8888877777");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(response.getEntity().getContent());
		actual = new DomParserResponse().parse(document);
		assertEquals(actual, expected);
		logger.info("Validate profile info: \nExpected " + expected + "\nActual " + actual);
	}
}

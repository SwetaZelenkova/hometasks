package edu.pht.cucumbertestng.restapi;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import edu.pht.cucumbertestng.beans.SimpleResponse;

public class SimpleResponseHandler extends DefaultHandler
	{
	    private SimpleResponse response;
	    private boolean isResponse = false;

	    public SimpleResponse getResponse()
	    {
	        return response;
	    }

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	    {
	        if (qName.equalsIgnoreCase("response"))
	        {
	            response = new SimpleResponse();
	            isResponse = true;
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException
	    {
	    }

	    @Override
	    public void characters(char ch[], int start, int length) throws SAXException
	    {

	        if (isResponse)
	        {
	            response.setResponse(new String(ch, start, length));
	            isResponse = false;
	        }
	    }
	}

package staxparser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import modelemail.Email;

public class StaxParser {

    private static final String BODY = "body";
    private static final String SUBJECT = "subject";
    private static final String COPYTO = "copyTo";
    private static final String MESSAGETORECEIVER = "messageToReceiver";
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private Email email;
    List<Email> emails = new ArrayList<>();

    public List<Email> parse(XMLEventReader xmlEventReader) throws FileNotFoundException, XMLStreamException
    {
        while (xmlEventReader.hasNext())
        {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            proceedStartElement(xmlEvent, xmlEventReader);
            proceedEndElement(xmlEvent);
        }
        return emails;
    }

    private void proceedStartElement(XMLEvent xmlEvent, XMLEventReader xmlEventReader) throws XMLStreamException
    {
        if (xmlEvent.isStartElement())
        {
            StartElement startElement = xmlEvent.asStartElement();
            if (isTagNameEqual(startElement, EMAIL))
            {
            	email = new Email();
                Attribute attribute = startElement.getAttributeByName(new QName(ID));
                if (attribute != null)
                {
                	email.setId(Integer.parseInt(attribute.getValue()));
                }
            }
            // set the other varibles from xml elements
            else if (isTagNameEqual(startElement, MESSAGETORECEIVER))
            {
            	email.setMessageToReceiver(xmlEventReader.nextEvent().asCharacters().getData());
            }
            else if (isTagNameEqual(startElement, COPYTO))
            {
            	email.setCopyTo(xmlEventReader.nextEvent().asCharacters().getData());
            }
            else if (isTagNameEqual(startElement, SUBJECT))
            {
            	email.setSubject(xmlEventReader.nextEvent().asCharacters().getData());
            }
            else if (isTagNameEqual(startElement, BODY))
            {
            	email.setBody(xmlEventReader.nextEvent().asCharacters().getData());
            }
        }
    }

    private void proceedEndElement(XMLEvent xmlEvent)
    {
        if (xmlEvent.isEndElement())
        {
            EndElement endElement = xmlEvent.asEndElement();
            if (endElement.getName().getLocalPart().equals(EMAIL))
            {
            	emails.add(email);
            }
        }
    }

    private boolean isTagNameEqual(StartElement startElement, String tagName)
    {
        return startElement.getName().getLocalPart().equals(tagName);
    }
}

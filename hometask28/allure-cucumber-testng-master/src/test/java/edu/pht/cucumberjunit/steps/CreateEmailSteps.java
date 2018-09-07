package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumberjunit.beans.Email;
import edu.pht.cucumberjunit.pages.CreateEmailPage;
import edu.pht.cucumberjunit.utils.Director;
import edu.pht.cucumberjunit.utils.Driver;
import edu.pht.cucumberjunit.utils.EmailBuilder;
import edu.pht.cucumberjunit.utils.EmailWithDataFromDBBuilder;
import edu.pht.cucumberjunit.utils.EmailWithDataFromXMLBuilder;

public class CreateEmailSteps {

	private static final Logger logger = Logger.getLogger(CreateEmailSteps.class);
	public static final String RECIPIENTS_EMAIL_ADDRESS = "yuta_yuta@tut.by";
	public static final String SUBJECT_OF_EMAIL = "I love java";
	public static final String TEXT_OF_EMAIL = "I want to be developer of autotests";
	private WebDriver driver;
	private CreateEmailPage createEmailPage;

	public CreateEmailSteps() {
		logger.info("Tests of emails creating are starting.....");
		driver = Driver.getInstance();
		createEmailPage = new CreateEmailPage(driver);
		logger.info("CreateEmailPage initialization finished.....");
	}

	@And("^I enter the recipients email address$")
	public void enterEmailAddress() {
		createEmailPage.enterRecipientsEmailAddress(RECIPIENTS_EMAIL_ADDRESS);
		createEmailPage.makeScreenshot();
		logger.info("Email address is entering.....");
	}

	@And("^I enter more recipients email addresses \"([^\"]*)\", \"([^\"]*)\"$")
	public void enterMoreEmailAddresses(String email1, String email2) {
		createEmailPage.enterMoreEmailAddresses(RECIPIENTS_EMAIL_ADDRESS, email1, email2);
		createEmailPage.makeScreenshot();
		logger.info("More email addresses are entering.....");
	}

	@And("^I enter the subject of the email$")
	public void enterSubjectOfEmail() {
		createEmailPage.enterSubjectOfEmail(SUBJECT_OF_EMAIL);
		createEmailPage.makeScreenshot();
		logger.info("Subject of the email is entering.....");
	}

	@And("^I enter the body of the email$")
	public void enterBodyOfEmail() {
		createEmailPage.enterBodyOfEmail(TEXT_OF_EMAIL);
		createEmailPage.makeScreenshot();
		logger.info("Body of the email is entering.....");
	}

	@And("^I enter the recipients email address, more addresses as copyTo, subject of the email, body of the email with (\\d+) from DB$")
	public void enterFullEmailsInfoFromDB(int id) {
		setFullInfo(getFullInfo(new EmailWithDataFromDBBuilder().init(id)));
		logger.info("Info from DB with id = " + id + " is entering.....");
	}

	@And("^I enter the recipients email address, more addresses as copyTo, subject of the email, body of the email with (\\d+) from XML$")
	public void enterFullEmailsInfoFromXML(int id) {
		setFullInfo(getFullInfo(new EmailWithDataFromXMLBuilder().init(id)));
		logger.info("Info from XML with id = " + id + " is entering.....");
	}

	@And("^I click on the button send mail$")
	public void clickButtonSendMail() {
		createEmailPage.clickButtonSendEmail();
	}

	@Then("^I see message Your letter has been sent$")
	public void isSentMessagePresents() {
		assertTrue(createEmailPage.isMessageSentEmailPresents());
	}

	private Email getFullInfo(EmailBuilder builder) {
		Director director = new Director();
		director.setBuilder(builder);
		Email email = director.buildEmail();
		return email;
	}

	private void setFullInfo(Email email) {
		createEmailPage.enterRecipientsEmailAddress(email.getEmail());
		logger.info(email.getEmail());
		createEmailPage.enterMoreEmailAddresses(email.getMoreEmails());
		logger.info(email.getMoreEmails());
		createEmailPage.enterSubjectOfEmail(email.getSubject());
		logger.info(email.getSubject());
		createEmailPage.enterBodyOfEmail(email.getBody());
		logger.info(email.getBody());
	}
}

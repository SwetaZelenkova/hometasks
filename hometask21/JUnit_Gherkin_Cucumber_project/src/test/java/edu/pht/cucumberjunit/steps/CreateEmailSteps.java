package edu.pht.cucumberjunit.steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import edu.pht.cucumberjunit.CreateEmailPage;
import edu.pht.cucumberjunit.Driver;
import edu.pht.cucumberjunit.EmailPage;

public class CreateEmailSteps {

	public static final String RECIPIENTS_EMAIL_ADDRESS = "yuta_yuta@tut.by";
	public static final String SUBJECT_OF_EMAIL = "I love java";
	public static final String TEXT_OF_EMAIL = "I want to be developer of autotests";
	private WebDriver driver;
	private CreateEmailPage createEmailPage;
	private EmailPage emailPage;

	public CreateEmailSteps() {
		driver = Driver.getInstance();
		createEmailPage = new CreateEmailPage(driver);
		emailPage = new EmailPage(driver);
	}
	
	@And("^I click on the button create mail$")
	public void clickButtonCreateMail() {
		emailPage.createMail();
	}
	
	@And("^I enter the recipients email address$")
	public void enterEmailAddress() {
		createEmailPage.enterRecipientsEmailAddress(RECIPIENTS_EMAIL_ADDRESS);
	}
	
	@And("^I enter more recipients email addresses \"([^\"]*)\", \"([^\"]*)\"$")
	public void enterMoreEmailAddresses(String email1, String email2) {
		createEmailPage.enterMoreEmailAddresses(RECIPIENTS_EMAIL_ADDRESS, email1, email2);
	}
	
	@And("^I enter the subject of the email$")
	public void enterSubjectOfEmail() {
		createEmailPage.enterSubjectOfEmail(SUBJECT_OF_EMAIL);
	}
	
	@And("^I enter the body of the email$")
	public void enterBodyOfEmail() {
		createEmailPage.enterBodyOfEmail(TEXT_OF_EMAIL);
	}
	
	@And("^I click on the button send mail$")
	public void clickButtonSendMail() {
		createEmailPage.clickButtonSendEmail();
	}
	
	@Then("^I see message Your letter has been sent$")
	public void isSentMessagePresents() {
		assertTrue(createEmailPage.isMessageSentEmailPresents());
	}
}

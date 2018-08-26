package edu.pht.pageclasses;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CreateMailTest {

	private CreateMail createMail;

	@BeforeClass
	public void beforeClass() {
		createMail = new CreateMail();
		createMail.getDriver().get(Const.URL);
	}

	@Test
	public void create_and_send_Mail_Test() {
		createMail.enterLoginAndPass(Const.LOGIN, Const.DOMAIN, Const.PASSWORD);
		createMail.clickEnterButton();
		createMail.create();
		createMail.write(Const.EMAIL, Const.JAVA, Const.TEST);
		createMail.clickButtonSend();
		Assert.assertTrue(createMail.sentMessagePresents());
	}

	@AfterClass
	public void afterClass() {
		createMail.quitDriver();
	}
}

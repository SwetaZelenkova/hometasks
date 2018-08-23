package edu.pht.pageclasses;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendMailToGroupReciversTest {

	private SendMailToGroupRecivers mailToGroupRecivers;

	@BeforeClass
	public void beforeClass() {
		mailToGroupRecivers = new SendMailToGroupRecivers();
		mailToGroupRecivers.getDriver().get(Const.URL);
	}

	@Test
	public void send_Mail_To_Group_Recivers_Test() {
		mailToGroupRecivers.enterLoginAndPass(Const.LOGIN, Const.DOMAIN, Const.PASSWORD);
		mailToGroupRecivers.clickEnterButton();
		mailToGroupRecivers.create();
		mailToGroupRecivers.write(Const.EMAIL, Const.JAVA, Const.TEST, "lana_zelenkova@tut.by", "nika.benz@tut.by",
				Const.EMAIL);
		mailToGroupRecivers.clickButtonSend();
		assertTrue(mailToGroupRecivers.sentMessagePresents());
	}

	@AfterClass
	public void afterClass() {
		mailToGroupRecivers.quitDriver();
	}
}

package edu.pht.pageclasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RelocationOutSpamTest {

	private RelocationOutSpam relocationOutSpam;

	@BeforeClass
	public void beforeClass() {
		relocationOutSpam = new RelocationOutSpam();
		relocationOutSpam.getDriver().get(Const.URL);
	}

	@Test
	public void relocation_Out_Spam_Test() {
		relocationOutSpam.enterLoginAndPass(Const.LOGIN, Const.DOMAIN, Const.PASSWORD);
		relocationOutSpam.clickEnterButton();
		relocationOutSpam.relocate();
		Assert.assertTrue(relocationOutSpam.notifyMessagePresents().getText().contains(Const.SPAM));
	}

	@AfterClass
	public void afterClass() {
		relocationOutSpam.quitDriver();
	}

}

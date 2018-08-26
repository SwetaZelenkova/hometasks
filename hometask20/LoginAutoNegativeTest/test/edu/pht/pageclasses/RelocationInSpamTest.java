package edu.pht.pageclasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RelocationInSpamTest {

	private RelocationInSpam relocationInSpam;

	@BeforeClass
	public void beforeClass() {
		relocationInSpam = new RelocationInSpam();
		relocationInSpam.getDriver().get(Const.URL);
	}

	@Test
	public void relocation_In_Spam_Test() {
		relocationInSpam.enterLoginAndPass(Const.LOGIN, Const.DOMAIN, Const.PASSWORD);
		relocationInSpam.clickEnterButton();
		relocationInSpam.relocate();
		Assert.assertTrue(relocationInSpam.isToSpam());
	}

	@AfterClass
	public void afterClass() {
		relocationInSpam.quitDriver();
	}
}

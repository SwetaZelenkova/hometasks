package edu.pht.pageclasses;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnmarkAllFlagsTest {

	private static final String LOGIN = "zelenkova-sveta";
	private static final String DOMAIN = "@bk.ru";
	private static final String PASSWORD = "Benz2503";
	private static final String URL = "https://mail.ru";
	private UnmarkAllFlags unmarkAllFlags;

	@BeforeClass
	public void beforeClass() {
		unmarkAllFlags = new UnmarkAllFlags();
		unmarkAllFlags.getDriver().get(URL);
	}

	@Test
	public void unmark_All_Flags_Test() {
		unmarkAllFlags.enterLoginAndPass(LOGIN, DOMAIN, PASSWORD);
		unmarkAllFlags.clickEnterButton();
		unmarkAllFlags.filterEmailsWithFlags();
		unmarkAllFlags.checkEmails();
		unmarkAllFlags.unmarkFlag();
		assertTrue(unmarkAllFlags.checkMessageAfterUnmarkAllFlags());
	}

	@AfterClass
	public void afterClass() {
		unmarkAllFlags.quitDriver();
	}
}

package edu.pht.pageclasses;

import org.testng.annotations.*;

import org.testng.Assert;

public class LoginPageNegativeTest {
	private LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage();
		loginPage.getDriver().get(Const.URL);

	}

	@Test
	public void loginTest() {
		loginPage.
		enterLoginAndPass(Const.LOGIN, 
						  Const.WRONG_DOMAIN, 
						  Const.PASSWORD);
		loginPage.clickEnterButton();
		Assert.assertTrue(loginPage
				.errorMessagePresents());
	}

	@AfterClass
	public void afterClass() {
		loginPage.quitDriver();
	}

}

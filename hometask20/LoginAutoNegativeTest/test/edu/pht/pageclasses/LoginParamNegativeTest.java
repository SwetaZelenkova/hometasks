package edu.pht.pageclasses;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginParamNegativeTest {

	private LoginPage loginPage;

	@Test(dataProvider = "dataForTest")
	public void login_Param_Negative_Test(String login, String domain, String password, Boolean expected) {
		loginPage.enterLoginAndPass(login, domain, password);
		loginPage.clickEnterButton();
		Assert.assertEquals(loginPage.errorMessagePresents(), expected);
	}

	@DataProvider
	public Object[][] dataForTest() {
		return new Object[][] { new Object[] { "zelenkova-sveta", "@list.ru", "Benz2503", true },
				new Object[] { "zelenkova-sveta", "@bk.ru", "Benz_503", true },
				new Object[] { "zelenkova_sveta", "@bk.ru", "Benz2503", true },
				new Object[] { "zelenkova-sveta", "@mail.ru", "Benz2503", true },
				new Object[] { "", "@bk.ru", "Benz2503", true },
				new Object[] { "ZEL-ENKOVA-SVETA", "@bk.ru", "Benz2503", true } };
	}

	@BeforeClass
	public void beforeClass() {
		loginPage = new LoginPage();
		loginPage.getDriver().get(Const.URL);
	}

	@AfterClass
	public void afterClass() {
		loginPage.quitDriver();
	}

}

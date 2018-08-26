package edu.pht.pageclasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CleanRecycleBinTest {

	private CleanRecycleBin cleanRecycleBin;

	@BeforeClass
	public void beforeClass() {
		cleanRecycleBin = new CleanRecycleBin();
		cleanRecycleBin.getDriver().get(Const.URL);

	}

	@Test
	public void clean_Recycle_Bin_Test() {
		cleanRecycleBin.enterLoginAndPass(Const.LOGIN, Const.DOMAIN, Const.PASSWORD);
		cleanRecycleBin.clickEnterButton();
		cleanRecycleBin.clean();
		cleanRecycleBin.confirm();
		Assert.assertTrue(cleanRecycleBin.notifyMessagePresents());
	}

	@AfterClass
	public void afterClass() {
		cleanRecycleBin.quitDriver();
	}

}

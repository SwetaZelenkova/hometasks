package edu.pht.pageclasses;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AreIconsPresentTest {

	private AreIconsPresent areIconsPresent;

	@BeforeClass
	public void beforeClass() {
		areIconsPresent = new AreIconsPresent();
		areIconsPresent.getDriver().get(Const.URL);
	}

	@Test
	public void all_Icons_Present_Test() {
		assertTrue(areIconsPresent.checkIcons());
	}

	@AfterClass
	public void afterClass() {
		areIconsPresent.quitDriver();
	}
}

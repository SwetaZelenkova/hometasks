package edu.pht.pageclasses;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectThreeEmailsTest {
    
    private SelectThreeEmails selectThreeEmails;
    
    @BeforeClass
    public void beforeClass()
    {
    	selectThreeEmails = new SelectThreeEmails();
    	selectThreeEmails.getDriver().get(Const.URL);
    }

    @Test
    public void mark_Three_Emails_Test()
    {
    	selectThreeEmails.enterLoginAndPass(Const.LOGIN, Const.DOMAIN, Const.PASSWORD);
    	selectThreeEmails.clickEnterButton();
    	selectThreeEmails.checkEmails();
    	selectThreeEmails.markFlag();
		assertTrue(selectThreeEmails.notifyMessagePresents()
				.getText().contains(Const.MARK));
	}

	@AfterClass
    public void afterClass()
    {
		selectThreeEmails.quitDriver();
	}
}

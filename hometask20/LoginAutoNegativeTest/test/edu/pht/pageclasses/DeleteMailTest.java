package edu.pht.pageclasses;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteMailTest {
	
    private DeleteMail deleteMail;

    @BeforeClass
    public void beforeClass()
    {
        deleteMail = new DeleteMail();
        deleteMail.getDriver().get(Const.URL);

    }

    @Test
    public void delete_Mail_Test()
    {
    	deleteMail.enterLoginAndPass(Const.LOGIN, Const.DOMAIN, Const.PASSWORD);
    	deleteMail.clickEnterButton();
    	deleteMail.delete();
        Assert.assertTrue(deleteMail.notifyMessagePresents().getText().contains(Const.DELETE_LETTER));
    }

    @AfterClass
    public void afterClass()
    {
    	deleteMail.quitDriver();
    }

}

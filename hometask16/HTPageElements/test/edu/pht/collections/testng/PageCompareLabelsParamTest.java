package edu.pht.collections.testng;

import org.testng.annotations.Test;

import edu.pht.collections.entity.Label;
import edu.pht.collections.entity.Page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;

public class PageCompareLabelsParamTest {
	
  private Page page;
	
  @Test(groups = {"Difficult"}, dataProvider = "dp")
  public void Page_CompareLabels_Test(Label label1, Label label2, Integer expected) {
	  Integer actual = page.compareLabels(label1, label2);
	  assertEquals(actual, expected);
  }
  
  @DataProvider(name = "dp")
  public static Object[][] dataForTest() {
    return new Object[][] {
       { new Label("Name"), new Label("Name"), 0},
       { new Label("7"), new Label("7"), 0},
       { new Label("9"), new Label("1"), 1},
       { new Label("Address"), new Label("Password"), -1},
       { new Label("Prof"), new Label("Price"), 1},
       { new Label("Name"), new Label("Surname"), -1},
       { new Label("Age"), new Label("Age"), 0},
       { new Label("Company"), new Label("Factory"), -1},
       { new Label("Factory"), new Label("Company"), 1},
       { new Label(""), new Label(""), 0},
       { new Label("gender"), new Label("gender"), 0}
    };
  }
  
  @BeforeTest
  public void beforeTest() {
	  page = new Page();
  }

  @AfterTest
  public void afterTest() {
	  page = null;
  }

}

package edu.pht.collections.entity;

import org.testng.annotations.Test;

import edu.pht.collections.entity.Label;
import edu.pht.collections.entity.Page;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PageAddAllLabelsParamTest {
	
	private static Page page;
	private static HashSet<Label> labels;
	
  @Test(dataProvider = "dp")
  public void Page_AddAllLabels_Test(Label[] labs, boolean expected) {;
	  assertEquals(page.getLabels().size() + labs.length == page.addAllLabels(labs).size(), expected);
  }

  @DataProvider(name = "dp")
  public Object[][] dataForTest() {
    return new Object[][] {
    	{new Label[] {new Label("Label"), new Label("Item")}, true},
    	{new Label[] {new Label("Check"), new Label("Sum")}, true},
		{new Label[] {new Label("Size"), new Label("Totals")}, true},
		{new Label[] {new Label("Check"), new Label("Totals")}, false},
		{new Label[] {new Label("Size"), new Label("Item")}, false},
		{new Label[] {new Label("Sale"), new Label("Order")}, false}
    };
  }
  @BeforeClass
  public void beforeClass() {
	  page = new Page();
	  Label[] arrayLabels = { new Label("Bonus"), new Label("Discount"), new Label("Sale"), new Label("Product"), new Label("Order"), new Label("Price")};
	  /*for (Label labs: arrayLabels) {
		  labels.add(labs);
	  }*/
	  labels = new HashSet<>(Arrays.asList(arrayLabels));
	  page.setLabels(labels);
  }

  @AfterClass
  public void afterClass() {
	  page = null;
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}

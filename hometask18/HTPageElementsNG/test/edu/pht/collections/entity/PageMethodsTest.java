package edu.pht.collections.entity;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import edu.pht.collections.entity.Label;
import edu.pht.collections.entity.Page;

public class PageMethodsTest {
	
	private Page page;
	
	@Test
	public void test_CompareLabels_Not_Equals() {
		Label l1 = new Label("Age");
		Label l2 = new Label("age");
		int actual = page.compareLabels(l1, l2);
		int expected = 0;
		assertNotEquals(actual, expected);
	}
	
	@Test(enabled = false) // not class Page method - only class Page methods for testing
	public void test_Labels_Equals() {
		Label l1 = new Label("Name");
		Label l2 = new Label("Name");
		boolean actual = l1.equals(l2);
		boolean expected = true;
		assertEquals(actual, expected);
	}
	
	@Test
	public void test_CompareLabels_Equals() {
		Label l1 = new Label("Age");
		Label l2 = new Label("Gender");
		int actual = page.compareLabels(l1, l2);
		int expected = -1;
		assertEquals(actual, expected);
	}

	@BeforeMethod
	public void beforeMethod() {
		page = new Page();
	}
	
	@AfterMethod
	public void afterMethod() {
		page = null;
	}
}

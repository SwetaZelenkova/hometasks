package edu.pht.collections.entity;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestPageCompareLabelsParam {

	private static Page page;
	private Label label1, label2;
	
	public TestPageCompareLabelsParam(Label label1, Label label2) {
		this.label1 = label1;
		this.label2 = label2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> arrayLabelsForTest() {
		return Arrays.asList(new Object[][] {
			{new Label("Name"), new Label("Surname")}, 
			{new Label("Age"), new Label("Phone")}, 
			{new Label("Address"), new Label("Email")},
			{new Label("Confirm"), new Label("Pasword")}, 
			{new Label("Comment"), new Label("Prof")}
		});
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		page = new Page();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		page = null;
	}
	
	@Test
	public void testCompareLabels() {
		assertTrue(page.compareLabels(label1, label2) == -1);
	}
}

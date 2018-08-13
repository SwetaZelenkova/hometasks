package edu.pht.collections.entity;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestPageAddAllLabelsParam {
	
	private static Page page;
	private static HashSet<Label> labels;
	private Label[] labelsForTest;	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		page = new Page();
		labels = new HashSet<>();
		Label[] arrayLabels = { new Label("Bonus"), new Label("Discount"), new Label("Sale"), new Label("Product"), new Label("Order"), new Label("Price")};
		for (Label labs: arrayLabels) {
			labels.add(labs);
		}
		page.setLabels(labels);
	}

	public TestPageAddAllLabelsParam(Label[] labelsForTest) {
		this.labelsForTest = labelsForTest;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> paramsForTest() { //all labels are different
		return Arrays.asList(new Object[][] {
			{new Label[] {new Label("Label"), new Label("Item")}},
			{new Label[] {new Label("Check"), new Label("Sum")}},
			{new Label[] {new Label("Size"), new Label("Totals")}}
		});
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		page = null;
	}

	@Test
	public void test_AddAllLabels_To_Full_HashSet() {
		int expected = page.getLabels().size() + labelsForTest.length; // how many labels + number of labels in the test array
		int actual = page.addAllLabels(labelsForTest).size(); // total number of labels after method execution
		assertTrue(expected == actual);
	}
} //the size of labels after each test is increased by the length of the array: labelsForTest.length

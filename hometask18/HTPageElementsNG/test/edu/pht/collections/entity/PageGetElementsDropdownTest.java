package edu.pht.collections.entity;

import org.testng.annotations.Test;

import edu.pht.collections.comparator.SortedDropdownsByName;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PageGetElementsDropdownTest {

	private static Page page;
	private TreeSet<Dropdown> dropdowns;

	@Test(dataProvider = "dp")
	public void test_GetThirdElement(Dropdown dropdown, boolean expected) {
		Dropdown actual = getThirdItem();
		dropdowns.add(dropdown);
		Dropdown actualNext = getThirdItem();
		assertEquals(actualNext.equals(actual), expected);	
	}

	@BeforeMethod
	public void beforeMethod() {
		dropdowns = initDropdowns();
		page.setDropdowns(dropdowns);
	}

	@AfterMethod
	public void afterMethod() {
		dropdowns = null;
	}

	@DataProvider(name = "dp")
	public Object[][] dataForTest() {
		return new Object[][] {
				{ new Dropdown(new ArrayList<>(Arrays.asList(new String[] { "cat", "dog", "fish" })), true,
						"select animal"), false},
				{ new Dropdown(new ArrayList<>(Arrays.asList(new String[] { "nurce", "doctor", "vet" })), true,
						"select prof"), true}};
	}

	@BeforeClass
	public void beforeClass() {
		page = new Page();
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

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	private Dropdown getThirdItem() {
		int thirdElement = 3;
		int count = 0;
		if (dropdowns != null && dropdowns.size() >= thirdElement) {
			for (Dropdown searchElement : dropdowns) {
				count++;
				if (count == thirdElement) {
					return searchElement;
				}
			}
		}
		return null;
	}
	private ArrayList<String> arrayToOption(String[] s) {
		return new ArrayList<>(Arrays.asList(s));
	}

	private TreeSet<Dropdown> initDropdowns() {
		List<String> options1 = arrayToOption(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun" });
		Dropdown d1 = new Dropdown(options1, true, "select month");
		List<String> options2 = arrayToOption(new String[] { "male", "female" });
		Dropdown d2 = new Dropdown(options2, false, "select gender");
		List<String> options3 = arrayToOption(new String[] { "18 - 31", "32 - 44", "45+" });
		Dropdown d3 = new Dropdown(options3, true, "Your age");
		List<String> options4 = arrayToOption(new String[] { "Angola", "Benin", "Lichtenstain" });
		Dropdown d4 = new Dropdown(options4, true, "select country");
		TreeSet<Dropdown> dropdowns = new TreeSet<>(new SortedDropdownsByName());
		dropdowns.add(d1);
		dropdowns.add(d2);
		dropdowns.add(d3);
		dropdowns.add(d4);
		return dropdowns;
	}
}

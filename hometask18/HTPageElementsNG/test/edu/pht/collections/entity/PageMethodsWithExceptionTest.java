package edu.pht.collections.entity;

import org.testng.annotations.Test;

import edu.pht.collections.exception.InvalidActionException;
import edu.pht.collections.exception.NoSuchEntityException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PageMethodsWithExceptionTest {

	private static Page page;
	private LinkedList<Field> fields;
	private HashSet<Label> labels;
	private TreeSet<Dropdown> dropdowns;

	@Test(groups = { "functest" })
	public void test_GetFirstField() throws NoSuchEntityException {
		Field expected = new Field(6, "dateBirthfield");
		Field actual = page.getFirstField();
		assertEquals(actual, expected);
	}

	@Test(expectedExceptions = NoSuchEntityException.class)
	public void test_GetFirstField_Exception() throws NoSuchEntityException {
		page.setFields(new LinkedList<Field>());
		page.getFirstField();
	}

	@Test
	public void test_GetFirstField_Message_Exception() {
		page.setFields(new LinkedList<Field>());
		try {
			page.getFirstField();
			fail("error! test fail!");
		} catch (NoSuchEntityException e) {
			assertEquals(e.getMessage(),
					" NoSuchEntityException ->  LogicException -> field element not found -> list of fields is empty");
		}
	}

	@Test(groups = { "functest" })
	public void test_GetLastField() throws NoSuchEntityException {
		Field expected = new Field(4, "emailfield");
		Field actual = page.getLastField();
		assertEquals(actual, expected);
	}

	@Test(expectedExceptions = NoSuchEntityException.class)
	public void test_GetLastField_Exception() throws NoSuchEntityException {
		page.setFields(new LinkedList<Field>());
		page.getLastField();
	}

	@Test
	public void test_GetLastField_Message_Exception() {
		page.setFields(new LinkedList<Field>());
		try {
			page.getLastField();
			fail("error! test fail!");
		} catch (NoSuchEntityException e) {
			assertEquals(e.getMessage(),
					" NoSuchEntityException ->  LogicException -> field element not found -> list of fields is empty");
		}
	}

	@Test(expectedExceptions = InvalidActionException.class)
	public void test_In_Exception() throws InvalidActionException {
		ArrayList<Label> labs = new ArrayList<>(labels);
		page.in(labs);
	}

	@Test
	public void test_In_Message_Exception() {
		ArrayList<Label> labs = new ArrayList<>(labels);
		try {
			page.in(labs);
			fail("error! test fail!");
		} catch (InvalidActionException e) {
			assertEquals(e.getMessage(),
					" InvalidActionException ->  LogicException -> collection element must extends class Dropdown -> this is a unvailable action");
		}
	}

	@Test(expectedExceptions = NoSuchEntityException.class)
	public void test_GetElementsDropdown_Exception() throws NoSuchEntityException {
		page.getElementsDropdown();
	}

	@Test
	public void test_GetElementsDropdown_Message_Exception() {
		try {
			page.getElementsDropdown();
			fail("error! test fail!");
		} catch (NoSuchEntityException e) {
			assertEquals(e.getMessage(),
					" NoSuchEntityException ->  LogicException -> the saved third can not be found for set -> to store the order of the elements use list");
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		fields = new LinkedList<>(Arrays.asList(
				new Field[] { new Field(6, "dateBirthfield"), new Field(5, "phonefield"), new Field(1, "textfield"),
						new Field(2, "textarea"), new Field(3, "passwordfield"), new Field(4, "emailfield") }));
		labels = new HashSet<>(Arrays.asList(new Label[] { new Label("Name"), new Label("Surname"), new Label("Age"),
				new Label("Phone"), new Label("Address"), new Label("Gender"), new Label("Prof"), new Label("Hobby"),
				new Label("Email"), new Label("Password") }));
		dropdowns = new TreeSet<Dropdown>();
		page.setId(1);
		page.setTitle("title");
		page.setFields(fields);
		page.setLabels(labels);
		page.setDropdowns(dropdowns);
	}

	@AfterMethod
	public void afterMethod() {
		fields = null;
		labels = null;
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

}

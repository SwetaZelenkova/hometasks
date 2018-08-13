package edu.pht.collections.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.pht.collections.exception.InvalidActionException;
import edu.pht.collections.exception.NoSuchEntityException;

public class TestPageMethodsWithExceptions {
	private static Page page;
	private LinkedList<Field> fields;
	private HashSet<Label> labels;
	private TreeSet<Dropdown> dropdowns;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		page = new Page();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		page = null;
	}

	@Before
	public void setUp() throws Exception {
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

	@After
	public void tearDown() throws Exception {
		fields = null;
		labels = null;
	}

	@Test
	public void test_GetFirstField() throws NoSuchEntityException {
		Field expected = new Field(6, "dateBirthfield");
		Field actual = page.getFirstField();
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchEntityException.class)
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
			assertEquals(
					" NoSuchEntityException ->  LogicException -> field element not found -> list of fields is empty",
					e.getMessage());
		}
	}

	@Test
	public void test_GetLastField() throws NoSuchEntityException {
		Field expected = new Field(4, "emailfield");
		Field actual = page.getLastField();
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchEntityException.class)
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
			assertEquals(
					" NoSuchEntityException ->  LogicException -> field element not found -> list of fields is empty",
					e.getMessage());
		}
	}

	@Test(expected = InvalidActionException.class)
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
			assertEquals(
					" InvalidActionException ->  LogicException -> collection element must extends class Dropdown -> this is a unvailable action",
					e.getMessage());
		}
	}

	@Test(expected = NoSuchEntityException.class)
	public void test_GetElementsDropdown_Exception() throws NoSuchEntityException {
		page.getElementsDropdown();
	}

	@Test
	public void test_GetElementsDropdown_Message_Exception() {
		try {
			page.getElementsDropdown();
			fail("error! test fail!");
		} catch (NoSuchEntityException e) {
			assertEquals(" NoSuchEntityException ->  LogicException -> the saved third can not be found for set -> to store the order of the elements use list",
					e.getMessage());
		}
	}
}

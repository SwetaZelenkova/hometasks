package edu.pht.collections.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.pht.collections.comparator.SortArrayListButtons;
import edu.pht.collections.comparator.SortLinkedListFields;

public class TestPageMethods {

	private static Page page;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		page = new Page();
		Button[] arrayButtons = { new Button("confirm", "click"), new Button("go to page", "doubleclick"),
				new Button("save", "save") };
		ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(arrayButtons));
		Label[] arrayLabels = { new Label("Name"), new Label("Age"), new Label("Gender") };
		HashSet<Label> labels = new HashSet<Label>(Arrays.asList(arrayLabels));
		page.setButtons(buttons);
		page.setLabels(labels);
	}

	@Test
	public void test_ButtonContains_With_AssertTrue() {
		Button[] array = { new Button("confirm", "click"), new Button("go to page", "doubleclick"),
				new Button("save", "save") };
		for (Button button : array) {
			assertTrue("page does not contain this button: " + button.toString(), page.containsButton(button));
		}

	}

	@Test
	public void test_ButtonContains_With_AssertFalse() {
		Button[] array = { new Button("confirm", "XXXXX"), new Button("YY", "doubleclick"),
				new Button("save", "Zave") };
		for (Button button : array) {
			assertFalse("page contain this button: " + button.toString(), page.containsButton(button));
		}

	}

	@Test
	public void test_ContainsButton_With_AssertEquals() {
		boolean actual = page.containsButton(new Button("confirm", "click"));
		boolean expected = true;
		assertEquals(expected, actual);

	}

	@Test
	public void test_Labels_Equals() {
		Label l1 = new Label("Name");
		Label l2 = new Label("Name");
		boolean actual = l1.equals(l2);
		boolean expected = true;
		assertEquals(expected, actual);

	}

	@Test
	public void test_CompareLabels_Equals() {
		Label l1 = new Label("Age");
		Label l2 = new Label("Gender");
		int actual = page.compareLabels(l1, l2);
		int expected = -1;
		assertEquals(expected, actual);

	}

	@Test
	public void test_CompareLabels_Not_Equals() {
		Label l1 = new Label("Age");
		Label l2 = new Label("age");
		int actual = page.compareLabels(l1, l2);
		int expected = 0;
		assertNotEquals(expected, actual);

	}

	@Test
	public void test_FildsCompareTo() {
		Field f1 = new Field(2, "textarea");
		Field f2 = new Field(2, "textarea");
		int actual = f1.compareTo(f2);
		int expected = 0;
		assertEquals(expected, actual);

	}

	@Test
	public void test_SortArrayListButtons() {
		ArrayList<Button> buttons = new ArrayList<>();
		buttons.add(new Button("save to disk", "save"));
		buttons.add(new Button("confirm", "click"));
		buttons.add(new Button("go to page", "doubleclick"));
		buttons.add(new Button("cancel", "click"));
		buttons.add(new Button("save", "save"));
		ArrayList<Button> actual = SortArrayListButtons.sort(buttons);
		ArrayList<Button> expected = new ArrayList<>();
		expected.add(0, new Button("cancel", "click"));
		expected.add(1, new Button("confirm", "click"));
		expected.add(2, new Button("go to page", "doubleclick"));
		expected.add(3, new Button("save", "save"));
		expected.add(4, new Button("save to disk", "save"));

		assertArrayEquals(expected.toArray(), actual.toArray());
	}

	@Test
	public void test_SortLinkedListFields_By_Value() {
		LinkedList<Field> actual = SortLinkedListFields.sortByValue(initFields());
		LinkedList<Field> expected = new LinkedList<>(Arrays.asList(new Field[] {new Field(7, "comment"), new Field(8, "confirm"), 
				new Field(6, "dateBirth"), new Field(4, "email"), new Field(3, "password"), new Field(5, "phone"),
				new Field(1, "text"), new Field(2, "textarea")}));
		
		assertArrayEquals(expected.toArray(), actual.toArray());
		
	}
	
	@Test
	public void test_SortLinkedListFields_By_Id() {
		LinkedList<Field> actual = SortLinkedListFields.sortById(initFields());
		LinkedList<Field> expected = new LinkedList<>(Arrays.asList(new Field[] {new Field(1, "text"), new Field(2, "textarea"), 
				new Field(3, "password"), new Field(4, "email"), new Field(5, "phone"), new Field(6, "dateBirth"),
				new Field(7, "comment"), new Field(8, "confirm")}));
		
		assertArrayEquals(expected.toArray(), actual.toArray());
		
	}
	
	private LinkedList<Field> initFields() {
		Field[] arrayFields = { 
				new Field(6, "dateBirth"), 
				new Field(5, "phone"), 
				new Field(1, "text"),
				new Field(2, "textarea"), 
				new Field(3, "password"), 
				new Field(4, "email"), 
				new Field(8, "confirm"),
				new Field(7, "comment")};
		LinkedList<Field> fields = new LinkedList<>(Arrays.asList(arrayFields));
		return fields;
	}
}

package edu.pht.collections.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.pht.collections.comparator.SortArrayListButtons;

public class TestPageMethods {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testButtonContainsWithAssertTrue() {
		Button[] array = { new Button("confirm", "click"), new Button("go to page", "doubleclick"), new Button("save", "save")};
		ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(array));
		Page page1 = new Page(buttons, null, null, null, 1f, "new page");
		assertTrue(page1.containsButton(new Button("save", "save")));

	}

	@Test
	public void testLabelsEquals() {
		Label l1 = new Label("Name");
		Label l2 = new Label("Name");
		boolean actual = l1.equals(l2);
		boolean expected = true;
		assertEquals(actual, expected);

	}

	@Test
	public void testCompareLabels() {
		Label l1 = new Label("Age");
		Label l2 = new Label("Gender");
		HashSet<Label> labels = new HashSet<Label>();
		labels.add(l1);
		labels.add(l2);
		Page page1 = new Page(new ArrayList<Button>(), null, labels, new TreeSet<Dropdown>(), 1f, "new page");
		int actual = page1.compareLabels(l1, l2);
		int expected = -1;
		assertEquals(actual, expected);

	}

	@Test
	public void testFildsCompareTo() {
		Field f1 = new Field(2, "textarea");
		Field f2 = new Field(2, "textarea");
		int actual = f1.compareTo(f2);
		int expected = 0;
		assertEquals(actual, expected);

	}

	@Test
	public void testContainsButton() {
		Button[] array = { new Button("confirm", "click"), new Button("go to page", "doubleclick") };
		ArrayList<Button> buttons = new ArrayList<>(Arrays.asList(array));
		Page page1 = new Page(buttons, null, null, null, 1f, "new page");
		boolean actual = page1.containsButton(new Button("confirm", "click"));
		boolean expected = true;
		assertEquals(actual, expected);

	}
}
	
	/*@Test
	public void testSortArrayListButtons() {
		ArrayList<Button> buttons = new ArrayList<>();
		buttons.add(new Button("save", "save"));
		buttons.add(new Button("confirm", "click"));
		buttons.add(new Button("go to page", "doubleclick"));
		buttons.add(new Button("cancel", "click"));
		buttons.add(new Button("save", "save"));
		ArrayList<Button> actual = SortArrayListButtons.sort(buttons);
		ArrayList<Button> expected = new ArrayList<>();
		actual.add(0, new Button("cancel", "click"));
		actual.add(1, new Button("confirm", "click"));
		actual.add(2, new Button("go to page", "doubleclick"));
		actual.add(3, new Button("save", "save"));
		actual.add(4, new Button("save", "save"));
		boolean result = actual.equals(expected);
		
		assertTrue(result);
	}
}*/

package edu.pht.junittests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MassiveMethodsTest {

	private Massive massive;

	@Before
	public void setUp() throws Exception {
		massive = new Massive();
	}

	@After
	public void tearDown() throws Exception {
		massive = null;
	}

	@Test
	public void testCreateMassiveInConstructor() {
		int[] array = new int[] { 0, 1, 2, 3, 4, 
				5, 6, 7, 8, 9 };
		Massive massive = new Massive(array);
		int[] result = massive.getMassive();
		assertSame("references point to different "
				+ "parts of memory", array, result);
	}

	@Test
	public void testCreateMassiveWithSetMethod() {
		int[] array = new int[] { 10, 11, 12, 13, 
				14, 15, 16, 17, 18, 19 };
		Massive massive = new Massive();
		massive.setMassive(array);
		int[] result = massive.getMassive();
		assertSame("references point to different "
				+ "parts of memory", array, result);
	}

	@Test
	public void testLinksEqualsMassiveRevertMethod() {
		int[] array = new int[] { 5, 50, 25, 3, 10, 5 };
		massive.setMassive(array);
		int[] result = massive.revert();
		assertSame("references point to different "
				+ "parts of memory", array, result);
	}

	@Test
	public void testMassiveRevertMethod() {
		massive.setMassive(new int[] { 5, 50, 25, 3, 10, 5 });
		int[] actual = massive.revert();
		int[] expected = { 5, 10, 3, 25, 50, 5 };
		assertArrayEquals("arrays are not Equals", expected, actual);
	}

	@Test
	public void testMassiveBubbleSortMethod() {
		massive.setMassive(new int[] { 155, 50, 25, 3, 
				10, 5, 175, 0, -200, -1 });
		int[] actual = massive.bubbleSort();
		int[] expected = { -200, -1, 0, 3, 5, 10, 25, 50, 155, 175 };
		assertArrayEquals("arrays are not Equals", expected, actual);
	}

	@Test
	public void testMassiveInsertingSortMethod() {
		massive.setMassive(new int[] { -155, 510, -25, 
				13, 190, 5, 175, 0, -200, -1 });
		int[] actual = massive.insertingSort();
		int[] expected = { -200, -155, -25, -1, 0, 5, 13, 175, 190, 510 };
		assertArrayEquals("arrays are not Equals", expected, actual);
	}

	@Test
	public void testMassiveContainsNegativeNumbersTrueMethod() {
		massive.setMassive(new int[] { -155, 510, -25, 13, 
				190, 5, 175, 0, -200, -1 });
		boolean actual = massive.containsNegativeNumbers();
		assertTrue("does not contain negative numbers", actual);
	}

	@Test
	public void testMassiveContainsNegativeNumbersFalseMethod() {
		massive.setMassive(new int[] { 155, 510, 25, 13, 
				190, 5, 175, 0, 200, 1 });
		boolean actual = massive.containsNegativeNumbers();
		assertFalse("does not contain negative numbers", actual);
	}

	@Test
	public void testMassiveGetMinElementMethod() {
		massive.setMassive(new int[] { 155, 510, 25, 13, 
				190, 5, 175, 0, 200, 1 });
		int actual = massive.getMinElement();
		int expected = 0;
		assertEquals("not eq", expected, actual);
	}

	@Test
	public void testMassiveGetMaxElementMethod() {
		massive.setMassive(new int[] { 155, 510, 25, 13, 
				190, 5, 175, 0, 200, 1 });
		int actual = massive.getMaxElement();
		int expected = 510;
		assertEquals("not eq", expected, actual);
	}

	@Test
	public void testMassiveSumAllElementsMethod() {
		massive.setMassive(new int[] { 155, 510, 25, 13, 
				190, 5, 0, 0, 200, 1 });
		int actual = massive.sumAllElements();
		int expected = 1099;
		assertEquals("not eq", expected, actual);
	}

	@Test
	public void testMassiveProductAllElementsMethod() {
		massive.setMassive(new int[] { 155, 510, 25, 13, 
				190, 5, 0, 0, 200, 1 });
		long actual = massive.productAllElements();
		long expected = 0;
		assertEquals("not eq", expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMassivePrintMethod() {
		massive.setMassive(new int[] { 135, 70, 25, 13, 
				190, 5, 0, 0, 200, 1 });
		massive.print(null);
	}

	@Test(timeout = 1000)
	public void testTimeInsertingSortMethod() {
		massive.setMassive(new int[] { 1188, 999, -155, 
				510, -25, 13, 190, 5, 175, 0, -200, -1, 
				-155, 510, -25, 13, 190,
				5, 175, 0, -200, -1 });
		massive.insertingSort();
	}

	@Test(timeout = 1000)
	public void testTimeBubbleSortMethod() {
		massive.setMassive(new int[] { 1188, 999, -155, 
				510, -25, 13, 190, 5, 175, 0, -200, -1, 
				-155, 510, -25, 13, 190,
				5, 175, 0, -200, -1 });
		massive.bubbleSort();
	}

	@Ignore
	@Test
	public void testMassiveResultPrintMethod() {
		massive.setMassive(new int[] { 1188, 999, -155, 
				510, -25, 13, 0 });
		String actual = massive.print(massive.getMassive());
		String expected = "1188|999|-155|510|-25|13|0|";
		assertEquals(massive.toString() + " not eq " 
				+ expected, expected, actual);
	}
}

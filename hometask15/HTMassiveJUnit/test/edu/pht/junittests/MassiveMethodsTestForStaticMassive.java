package edu.pht.junittests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MassiveMethodsTestForStaticMassive {
	private static Massive massive;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		massive = new Massive(new int[] { 11, 22, -9, 5, -5, 0 });
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		massive = null;
	}

	@Test
	public void testGetMiddleIndex() {
		assertTrue(massive.getMiddleIndex() == 3);
	}

	@Test
	public void testSumAllElements() {
		assertTrue(massive.sumAllElements() == 24);
	}

	@Test
	public void testProductAllElements() {
		assertTrue(massive.productAllElements() == 0);
	}

	@Test
	public void testGetMinElement() {
		assertTrue(massive.getMinElement() == -9);
	}

	@Test
	public void testGetMaxElement() {
		assertTrue(massive.getMaxElement() == 22);
	}

	@Test
	public void testContainsNegativeNumbers() {
		assertTrue(massive.containsNegativeNumbers());
	}

}

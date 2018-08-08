package edu.pht.junittests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ProductAllElementsParameterizedTest {

	private Massive massive;
	private int x1, x2, x3, x4, expected;
	
	public ProductAllElementsParameterizedTest(int x1, int x2, int x3, int x4, int expected) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection numbersForTest() {
		return Arrays.asList(new Object[][] {
			{1, 2, 3, 4, 24},
			{0, 999, 888, 777, 0},
			{-44, -2, 1, 1, 88},
			{-88, 1, 1, 1, -88},
			{11, 11, 11, 11, 14641}
		});	
	}
	@Before
	public void setUp() throws Exception {
		massive = new Massive();
	}

	@After
	public void tearDown() throws Exception {
		massive = null;
	}

	@Test
	public void testProductAllElements() {
		massive.setMassive(new int[] {x1, x2, x3, x4});
		assertEquals(expected, massive.productAllElements());
	}

}

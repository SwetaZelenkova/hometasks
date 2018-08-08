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
public class GetMinElementParameterizedTest {
	
	private Massive massive;
	private int x1, x2, x3, x4, x5, expected;

	public GetMinElementParameterizedTest(int x1, 
			int x2, int x3, int x4, int x5, int expected) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.x5 = x5;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
	public static Collection numbersForMinSearch() {
		return Arrays.asList(new Object[][] {
			{-188007, 0, 1, 88007, 188007, -188007},
			{0, 8, 5, 575, 1000, 0}
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
	public void testGetMinElement() {
		massive.setMassive(new int[] {x1, x2, x3, x4, x5});
		assertEquals(expected, massive.getMinElement());
	}

}

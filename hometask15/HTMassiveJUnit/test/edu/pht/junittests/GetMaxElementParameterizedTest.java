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
public class GetMaxElementParameterizedTest {
	
	private Massive massive;
	private int x1, x2, x3, x4, x5, x6, expected;
	
	public GetMaxElementParameterizedTest(int x1, int x2, int x3, int x4, 
			int x5, int x6, int expected) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.x5 = x5;
		this.x6 = x6;
		this.expected = expected;
	}

	@Parameterized.Parameters
	public static Collection setNumbersForTest() {
		return Arrays.asList(new Object[][] {
			{Integer.MAX_VALUE, 0, -11, -111, 10, Integer.MAX_VALUE, Integer.MAX_VALUE},
			{10, 10, 10, 10, 10, 10, 10}, 
			{0, -1, -2, -3, -4, -5, 0}
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
	public void testGetMaxElement() {
		massive.setMassive(new int[]{x1, x2, x3, x4, x5, x6});
		assertEquals(expected, massive.getMaxElement());
	}

}

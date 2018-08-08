package edu.pht.junittests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class SumAllElementsParameterizedTest {
	
	private Massive massive;
	private int x1, x2, x3, x4, x5, expected;
	
	public SumAllElementsParameterizedTest(int x1, int x2, int x3, int x4, int x5, int expected) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.x5 = x5;
		this.expected = expected;
	}

	@Rule
	public TestRule timeout = new Timeout(100);

	@Parameterized.Parameters
	public static Collection intNumbers() {
		return Arrays.asList(new Object[][] {
			{1, 2, 3, 4, 5, 15},
			{0, 0, 0, 0, 0, 0},
			{-1000, -2000, 300, 400, -1, -2301},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 2, 0},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -3*Integer.MIN_VALUE, 3, 0}
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
	public void testSumAllElements() {
		massive.setMassive(new int[] {x1, x2, x3, x4, x5});
		assertEquals(expected, massive.sumAllElements());
	}
}

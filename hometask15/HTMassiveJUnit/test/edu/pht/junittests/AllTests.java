package edu.pht.junittests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GetMaxElementParameterizedTest.class, 
			    GetMinElementParameterizedTest.class, 
			    MassiveMethodsTest.class,
			    ProductAllElementsParameterizedTest.class, 
			    SumAllElementsParameterizedTest.class })
public class AllTests {
	
}

package edu.pht.collections.entity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestPageAddAllLabelsParam.class, 
	TestPageCompareLabelsParam.class, 
	TestPageContainsButtonParam.class,
	TestPageMethods.class, 
	TestPageMethodsWithExceptions.class })
public class AllTests {

}

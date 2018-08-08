package edu.pht.collections;

import java.util.Comparator;

public class CatSortedByAge implements Comparator<Cat> {

	@Override
	public int compare(Cat c1, Cat c2) {
		int age1 = c1.getAge();
		int age2 = c2.getAge();
		if (age1 < age2) {
			return -1;
		} else if (age1 > age2) {
			return 1;
		}
		return 0;
	}

}

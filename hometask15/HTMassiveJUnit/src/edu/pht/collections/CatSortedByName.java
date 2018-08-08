package edu.pht.collections;

import java.util.Comparator;

public class CatSortedByName implements Comparator<Cat> {

	@Override
	public int compare(Cat c1, Cat c2) {
		String name1 = c1.getName();
		String name2 = c2.getName();
		int result = name1.compareTo(name2);
		if (result != 0) {
			return result / Math.abs(result);
		}
		return 0;
	}

}

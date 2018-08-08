package edu.pht.collections;

import java.util.Comparator;

public class CatSortedByGender implements Comparator<Cat> {

	@Override
	public int compare(Cat c1, Cat c2) {
		String g1 = String.valueOf(c1.getGender());
		String g2 = String.valueOf(c2.getGender());
		int result = g1.compareTo(g2);
		if (result != 0) {
			return result / Math.abs(result);
		}
		return 0;
	}

}

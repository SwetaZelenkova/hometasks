package edu.pht.collections.comparator;

import java.util.Comparator;

import edu.pht.collections.entity.Dropdown;

public class SortedDropdownsByName implements Comparator<Dropdown> {

	@Override
	public int compare(Dropdown d1, Dropdown d2) {
		String name1 = d1.getName();
		String name2 = d2.getName();
		int result = name1.compareTo(name2);
		if (result != 0) {
			return result/Math.abs(result);
		}
		return 0;
	}
}

package edu.pht.collections.comparator;

import java.util.LinkedList;
import edu.pht.collections.entity.Field;

public class SortLinkedListFields {

	public static LinkedList<Field> sortById(LinkedList<Field> unsorted) {

		Field temp = new Field(0, "");

		if (unsorted.size() > 1) {
			for (int i = 1; i < unsorted.size(); i++) {
				for (int j = i - 1; j >= 0; j--) {
					if (unsorted.get(j).getId() > (unsorted.get(j + 1).getId())) {

						temp = unsorted.get(j);
						unsorted.set(j, unsorted.get(j + 1));
						unsorted.set(j + 1, temp);

					}
				}
			}
		}
		return unsorted;
	}

	public static LinkedList<Field> sortByValue(LinkedList<Field> unsorted) {

		Field temp = new Field(0, "");

		if (unsorted.size() > 1) {
			for (int i = 1; i < unsorted.size(); i++) {
				for (int j = i; j > 0; j--) {
					if (unsorted.get(j - 1).getValue().compareTo(unsorted.get(j).getValue()) > 0) {

						temp = unsorted.get(j - 1);
						unsorted.set(j - 1, unsorted.get(j));
						unsorted.set(j, temp);

					}
				}
			}
		}
		return unsorted;
	}

}

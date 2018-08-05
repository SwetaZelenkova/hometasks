package edu.pht.collections.comparator;

import java.util.ArrayList;
import edu.pht.collections.entity.Button;

public class SortArrayListButtons {

	public static ArrayList<Button> sort(ArrayList<Button> unsorted) {

		Button temp = new Button("", "");

		if (unsorted.size() > 1) {
			for (int i = 0; i < unsorted.size(); i++) {
				for (int j = 0; j < unsorted.size() - i - 1; j++) {
					if (unsorted.get(j).getName().compareTo(unsorted.get(j + 1).getName()) > 0) {

						temp = unsorted.get(j);
						unsorted.set(j, unsorted.get(j + 1));
						unsorted.set(j + 1, temp);

					}
				}
			}
		}
		return unsorted;
	}
}

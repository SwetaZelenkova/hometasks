package edu.pht.collections.comparator;

import java.util.Comparator;
import edu.pht.collections.entity.Button;

public class SortedButtonsByName implements Comparator<Button> {

	@Override
	public int compare(Button b1, Button b2) {
		String name1 = b1.getName();
		String name2 = b2.getName();
		int result = name1.compareTo(name2);
		if (result != 0) {
			return result/Math.abs(result);
		}
		return 0;
	}
}

package edu.pht.collections.comparator;

import java.util.Comparator;
import edu.pht.collections.entity.Button;

public class SortedButtonsByAction implements Comparator<Button> {

	@Override
	public int compare(Button b1, Button b2) {
		String action1 = b1.getAction();
		String action2 = b2.getAction();
		int result = action1.compareTo(action2);
		if (result != 0) {
			return result / Math.abs(result);
		}
		return 0;
	}
}

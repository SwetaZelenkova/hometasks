package edu.pht.collections.comparator;

import java.util.Comparator;
import edu.pht.collections.entity.Field;

public class SortedFieldsByName implements Comparator<Field> {

	@Override
	public int compare(Field f1, Field f2) {
		String value1 = f1.getValue();
		String value2 = f2.getValue();
		int result = value1.compareTo(value2);
		if (result != 0) {
			return result / Math.abs(result);
		}
		return 0;
	}

}

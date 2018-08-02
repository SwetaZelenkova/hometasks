package edu.pht.workwhithstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11_17 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		String text = "В первом случае к первой группе относятся все ^^^^^^^^возможные символы, "
				+ "но при этом остается минимальное количество символов ****для второй группы. "
				+ "Во втором *случае для первой группы выбирается наименьшее количество "
				+ "символов, так как ((())))***&&& }}}}}]]]используется слабое совпадение. В "
				+ "третьем случае первой группе будет ?!.соответствовать вся строка, а для "
				+ "второй не остается ни одного символа,* так как вторая ((())))***@@@ }}}}}]]]группа использует слабое "
				+ "совпадение. С четвертой символьной группой всё иначе. ";
		Pattern p = Pattern.compile("[^a-zA-Zа-яА-ЯёЁ]+");
		Matcher m = p.matcher(text);
		while (m.find()) {
			map.put(m.group(), m.group().length());
		}
		int max = 0;
		String subStr = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				subStr = entry.getKey();
			}
		}
		System.out.println(" Искомая подстрока: " + subStr);
	}
}

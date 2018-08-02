package edu.pht.workwhithstrings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11_9 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		String text = "В первом случае к первой группе относятся все возможные символы, "
				+ "но при этом остается минимальное количество символов для второй группы. "
				+ "Во втором *случае для первой группы выбирается наименьшее количество "
				+ "символов, так как используется слабое совпадение. В "
				+ "третьем случае первой группе будет соответствовать вся строка, а для "
				+ "второй не остается ни одного символа,* так как вторая группа использует слабое "
				+ "совпадение. С четвертой символьной группой всё иначе. ";
		// текст для теста
		// String text1 = " первом первом первом ----первом ?первом первом ,первом
		// ПЕРВОМ !!!ПЕРВОМ ПЕРвоМ, ";
		String regexToWordsSearch = "[a-zA-Zа-яА-ЯёЁ]+";
		Pattern p = Pattern.compile(regexToWordsSearch);
		Matcher m = p.matcher(text); // text1
		while (m.find()) {
			System.out.println(m.group());
			list.add(m.group());
		}
		int count;
		Map<String, Integer> mapCount = new TreeMap<>();
		Set<String> set = new HashSet<>(list);
		for (String setStr : set) {
			count = 0;
			for (int i = 0; i < list.size(); i++) {
				if (setStr.equals(list.get(i))) {
					count++;
				}
			}
			mapCount.put(setStr, count);
		}
		for (Map.Entry<String, Integer> entry : mapCount.entrySet()) {
			System.out.println(" Слово    " + entry.getKey() + " -> встречается " + entry.getValue() + " раз(-а)");
		}

	}
}

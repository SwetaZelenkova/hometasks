package edu.pht.workwhithstrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11_21 {

	public static void main(String[] args) {
		int sum = 0;
		String text = "В первом случае к 2первой группе относятся770 все возможные символы, "
				+ "но при этом остается минимальное количество символов для второй группы. "
				+ "Во втором *случае для 99988первой группы выбирается наименьшее количество "
				+ "символов, так как используется слабое совпадение. 12345В "
				+ "третьем случае первой группе будет соответствовать вся строка, а для "
				+ "второй не остается ни одного символа, 1так как вторая 111группа использует слабое "
				+ "совпадение. С четвертой символьной группой всё иначе. 4";
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(text);
		while (m.find()) {
			sum += Integer.parseInt(m.group());
		}
		System.out.println(" Сумма всех цифр, встречающихся в тексте: " + sum);
	}
}

package edu.pht.strings;

import java.util.stream.Stream;

public class Task11_19 {

	public static void main(String[] args) {
		String text = "в первом случае к 2первой группе относятся770 все возможные символы, wwwwwwwwww"
				+ "но при этом остается минимальное количество си}}мволов для  gggggggg второй гру..ппы. "
				+ "Во втором *случае для 99988первой группы выбирается наименьшее количество "
				+ "символов, так как исполь[[зуется слабое совп?адение. 12345В qq"
				+ "третьем случае первой группе будет соответствовать вся строка, а для "
				+ "второй не оста=ется ни одн--ого символа,* 1так как вт)орая 111группа использует слабое "
				+ "совпадение. С четвертой символьной группой всё иначе. 4";
		Stream<String> wordsWithUp = Stream.of(text.split("\\s+")).map(word -> {
			char[] chars = word.toCharArray();
			boolean flag = true;
			for (char ch : chars) {
				if (Character.isLetter(ch)) {
					flag &= true;
				} else {
					flag &= false;
				}
			}
			if (flag && word.length() >= 2) {
				word = word.substring(0, 1).toUpperCase() + word.substring(1);
			} else if (flag && word.length() == 1) {
				word = word.toUpperCase();
			}
			return word;
		});
		wordsWithUp.forEach(toPrint -> System.out.print(toPrint + " "));
	}
}

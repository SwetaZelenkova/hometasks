package edu.pht.workwhithstrings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11_5 {

	public static void main(String[] args) {
		String wordEnding = "ой";
		String wordToInsertion = "ENDING";
		String text = "В первом случае к первой группе относятся все возможные символы, "
				+ "но при этом остается минимальное количество символов для второй группы. "
				+ "Во втором случае для первой группы выбирается наименьшее количество "
				+ "символов, так как используется слабое совпадение. В "
				+ "третьем случае первой группе будет соответствовать вся строкаой, а для "
				+ "второй не остается ни одного символа, так как вторая группа использует слабое "
				+ "совпадение. С четвертой символьной группой всё иначеой. ";
		String[] parts = text.split("[\\s+]");
		List<String> listNewNew = Arrays.asList(parts).stream().map(part -> {
			if (part.length() >= 2 && part.endsWith(wordEnding)) {
				part += wordToInsertion;
			} else if (part.length() >= 3 && part.substring(part.length() - 3, part.length() - 1).endsWith(wordEnding)
					&& (part.charAt(part.length() - 1) == '.' || part.charAt(part.length() - 1) == ','
							|| part.charAt(part.length() - 1) == '?' || part.charAt(part.length() - 1) == '!')) {
				part = part.substring(0, part.length() - 1) +  wordToInsertion + part.substring(part.length() - 1);
			} 
			return part;
		}).collect(Collectors.toList());
		String result = "";
		for (String s : listNewNew) {
			result += s + " ";
		}
		System.out.println(result);

	}

}

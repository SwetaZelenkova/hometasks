package edu.pht.strings;

public class Task11_8 {

	public static void main(String[] args) {
		// String symbFirst = "{";
		// String symbLast = "}";
		String symbDefault = "*";
		String text = "В первом случае к первой группе относятся все возможные символы, "
				+ "но при этом остается минимальное количество символов для второй группы. "
				+ "Во втором *случае для первой группы выбирается наименьшее количество "
				+ "символов, так как используется слабое совпадение. В "
				+ "третьем случае первой группе будет соответствовать вся строка, а для "
				+ "второй не остается ни одного символа,* так как вторая группа использует слабое "
				+ "совпадение. С четвертой символьной группой всё иначе. *";
		int first = text.indexOf(symbDefault);
		int last = text.lastIndexOf(symbDefault);
		text = text.substring(0, first) + text.substring(last + 1);
		System.out.println(text);
	}

	/*
	 * public static void main(String[] args) { String text =
	 * "{public static void  main(String[ ] args) { String input = \"abdcxyz\";" +
	 * "simpleMatches          (\"([a-z]*)([a-z]+)\",          input);" +
	 * "simpleMatches          (\"([a-z]?)([a-z]+)\",          input);" +
	 * "simpleMatches          (\"([a-z]+)([a-z]*)\",          input);" +
	 * "simpleMatches          (\"([a-z]?)([a-z]?)\",          input);}";
	 * System.out.println(text.replaceAll("\\s+",
	 * " ").replaceAll("[^\\sa-zA-Zа-яА-Я]", "")); }
	 */

}

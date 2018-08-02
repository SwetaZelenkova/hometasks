package edu.pht.workwhithstrings;

import java.util.Scanner;

public class Task11_6 {

	private static int k;
	private static String character;
	static Scanner scanner = new Scanner(System.in);
	private static String flag;

	public static void main(String[] args) {
		String text = "В первом случае к первой группе относятся \r\n"
				+ "все возможные символы, но при этом остается \r\n"
				+ "минимальное количество символов для второй группы. \r\n"
				+ "Во втором случае для первой группы выбирается \r\n"
				+ "наименьшее количество символов, так как используется слабое совпадение. \r\n"
				+ "В третьем случае первой группе будет соответствовать вся строка, \r\n"
				+ "а для второй не остается ни одного символа, \r\n"
				+ "так как вторая группа использует слабое совпадение. \r\n"
				+ "С четвертой символьной группой всё иначе.";
		String[] input = text.split("\\r\\n");
		for (String part : input) {
			System.out.println(part);
		}
		String exit;
		do {
			System.out.println("-------------------------------------------------------------------------------------");
			inputFlag();
			if (flag.equals("0")) {
				inputChar();
			} else {
				inputK();
				inputChar();
			}
			String result = changeLine(input, flag);
			System.out.println(result);
			System.out.println("Ещё разок, а? да/нет");
			exit = scanner.nextLine();
		} while (!exit.trim().toLowerCase().replace(" ", "").equals("нет"));
	}

	private static String changeLine(String[] input, String flag) {
		String textResult = "";
		if (input.length != 0) {
			if (flag.equals("1")) {
				for (int i = 0; i < input.length; i++) {
					if (input[i].length() >= k) {
						input[i] = new StringBuilder(input[i]).insert(k, character).toString();
						textResult += input[i] + "\n";
					} else {
						textResult += input[i] + "Входная последовательность имеет длину меньше данного индекса! "
								+ input[i].length() + " < " + k + "\n";
					}
				}
			}
			if (flag.equals("0")) {
				for (int i = 0; i < input.length; i++) {
					input[i] = input[i].replaceAll(character, "");
					textResult += input[i] + "\n";
				}
			}
		} else {
			textResult = "Вы не задали входную последовательность!";
		}
		return textResult;
	}

	public static void inputK() {
		do {
			System.out.println("Введите ненулевой порядковый номер - целое положительное число: ");
			while (!scanner.hasNextInt()) {
				System.out.println("это не число!");
				scanner.next();
			}
			k = scanner.nextInt();
		} while (k <= 0);
		System.out.println("получено число: " + k);
	}

	public static void inputChar() {
		System.out.println("Укажите символ: ");
		do {
			character = scanner.nextLine();
		} while (character.isEmpty());
		System.out.println("получен символ: " + character);
	}

	public static void inputFlag() {
		System.out.println("0 или 1: ");
		while (true) {
			flag = scanner.nextLine();
			flag = flag.trim();
			if (flag.equals("0") || flag.equals("1")) {
				break;
			} else if (flag.equals("")) {
				System.out.println("пустой ввод!");
			} else {
				System.out.println("выбор не сделан!");
			}
		}
	}
}

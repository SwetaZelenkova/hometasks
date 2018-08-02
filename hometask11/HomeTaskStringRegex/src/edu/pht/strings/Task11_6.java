package edu.pht.strings;

import java.util.Scanner;

public class Task11_6 {

	private static int k;
	private static String character;
	static Scanner scanner = new Scanner(System.in);
	private static String flag;

	public static void main(String[] args) {
		String text = "� ������ ������ � ������ ������ ��������� \r\n"
				+ "��� ��������� �������, �� ��� ���� �������� \r\n"
				+ "����������� ���������� �������� ��� ������ ������.\r\n"
				+ "�� ������ ������ ��� ������ ������ ���������� \r\n"
				+ "���������� ���������� ��������, ��� ��� ������������ ������ ����������.\r\n"
				+ "� ������� ������ ������ ������ ����� ��������������� ��� ������, \r\n"
				+ "� ��� ������ �� �������� �� ������ �������, \r\n"
				+ "��� ��� ������ ������ ���������� ������ ����������. \r\n"
				+ "� ��������� ���������� ������� �� �����.";
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
			System.out.println("��� �����, �? ��/���");
			exit = scanner.nextLine();
		} while (!exit.trim().toLowerCase().replace(" ", "").equals("���"));
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
						textResult += input[i] + "������� ������������������ ����� ����� ������ ������� �������! "
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
			textResult = "�� �� ������ ������� ������������������!";
		}
		return textResult;
	}

	public static void inputK() {
		do {
			System.out.println("������� ��������� ���������� ����� - ����� ������������� �����: ");
			while (!scanner.hasNextInt()) {
				System.out.println("��� �� �����!");
				scanner.next();
			}
			k = scanner.nextInt();
		} while (k <= 0);
		System.out.println("�������� �����: " + k);
	}

	public static void inputChar() {
		System.out.println("������� ������: ");
		do {
			character = scanner.nextLine();
		} while (character.isEmpty());
		System.out.println("�������� ������: " + character);
	}

	public static void inputFlag() {
		System.out.println("0 ��� 1: ");
		while (true) {
			flag = scanner.nextLine();
			flag = flag.trim();
			if (flag.equals("0") || flag.equals("1")) {
				break;
			} else if (flag.equals("")) {
				System.out.println("������ ����!");
			} else {
				System.out.println("����� �� ������!");
			}
		}
	}
}

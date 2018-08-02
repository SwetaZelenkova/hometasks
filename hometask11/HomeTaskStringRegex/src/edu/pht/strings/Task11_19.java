package edu.pht.strings;

import java.util.stream.Stream;

public class Task11_19 {

	public static void main(String[] args) {
		String text = "� ������ ������ � 2������ ������ ���������770 ��� ��������� �������, wwwwwwwwww"
				+ "�� ��� ���� �������� ����������� ���������� ��}}������ ���  gggggggg ������ ���..���. "
				+ "�� ������ *������ ��� 99988������ ������ ���������� ���������� ���������� "
				+ "��������, ��� ��� ������[[������ ������ ����?������. 12345� qq"
				+ "������� ������ ������ ������ ����� ��������������� ��� ������, � ��� "
				+ "������ �� ����=���� �� ���--��� �������,* 1��� ��� ��)���� 111������ ���������� ������ "
				+ "����������. � ��������� ���������� ������� �� �����. 4";
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

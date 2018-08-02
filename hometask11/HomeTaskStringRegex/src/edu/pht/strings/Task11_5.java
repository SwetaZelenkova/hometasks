package edu.pht.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11_5 {

	public static void main(String[] args) {
		String wordEnding = "��";
		String wordToInsertion = "ENDING";
		String text = "� ������ ������ � ������ ������ ��������� ��� ��������� �������, "
				+ "�� ��� ���� �������� ����������� ���������� �������� ��� ������ ������. "
				+ "�� ������ ������ ��� ������ ������ ���������� ���������� ���������� "
				+ "��������, ��� ��� ������������ ������ ����������. � "
				+ "������� ������ ������ ������ ����� ��������������� ��� ��������, � ��� "
				+ "������ �� �������� �� ������ �������, ��� ��� ������ ������ ���������� ������ "
				+ "����������. � ��������� ���������� ������� �� �������. ";
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

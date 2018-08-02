package edu.pht.strings;

import java.util.Map;
import java.util.TreeMap;

public class Task11_18 {

	public static void main(String[] args) {

		Map<Character, Integer> map = new TreeMap<> ();
		String text = "��������� �������� StringBuildddder__ �� StringBuffer �������� ������������������ ����������. "
				+ "����� ������� �������� ��������� ���� ;;��������� ���������� ������������������ ������ "
				+ "StringBuilddder. ***��� ������� ���������, ���� �� ������������ ����������� ������������� "
				+ "������� � ������������������� �������";
		int count;
		String regex = "[\\P{L}]+";
		String[] words = text.split(regex);
		char[] chars = { '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
				'�', 'b', 'c', 'd', 'f', 'g', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'w', 'x', 'z' };
		for (int k = 0; k < chars.length; k++) {
			count = 0;
			for (int i = 0; i < words.length; i++) {
				char[] letters = words[i].toLowerCase().toCharArray();
				for (int j = 0; j < letters.length; j++) {
					if (chars[k] == letters[j]) {
						count++;
						break;
					}
				}
			}
			map.put(chars[k], count);
		}
		for (Map.Entry<Character, Integer> me : map.entrySet()) {
			if (me.getValue() <= 2) {
			System.out.println(me.getKey() + " ����������� � " + me.getValue() + " ������ ");
			}
		}

	}

}

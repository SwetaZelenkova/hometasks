package edu.pht.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task11_17 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		String text = "� ������ ������ � ������ ������ ��������� ��� ^^^^^^^^��������� �������, "
				+ "�� ��� ���� �������� ����������� ���������� �������� ****��� ������ ������. "
				+ "�� ������ *������ ��� ������ ������ ���������� ���������� ���������� "
				+ "��������, ��� ��� ((())))***&&& }}}}}]]]������������ ������ ����������. � "
				+ "������� ������ ������ ������ ����� ?!.��������������� ��� ������, � ��� "
				+ "������ �� �������� �� ������ �������,* ��� ��� ������ ((())))***@@@ }}}}}]]]������ ���������� ������ "
				+ "����������. � ��������� ���������� ������� �� �����. ";
		Pattern p = Pattern.compile("[^a-zA-Z�-��-߸�]+");
		Matcher m = p.matcher(text);
		while (m.find()) {
			map.put(m.group(), m.group().length());
		}
		int max = 0;
		String subStr = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				subStr = entry.getKey();
			}
		}
		System.out.println(" ������� ���������: " + subStr);
	}
}

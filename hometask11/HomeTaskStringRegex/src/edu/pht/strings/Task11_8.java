package edu.pht.strings;

public class Task11_8 {

	public static void main(String[] args) {
		// String symbFirst = "{";
		// String symbLast = "}";
		String symbDefault = "*";
		String text = "� ������ ������ � ������ ������ ��������� ��� ��������� �������, "
				+ "�� ��� ���� �������� ����������� ���������� �������� ��� ������ ������. "
				+ "�� ������ *������ ��� ������ ������ ���������� ���������� ���������� "
				+ "��������, ��� ��� ������������ ������ ����������. � "
				+ "������� ������ ������ ������ ����� ��������������� ��� ������, � ��� "
				+ "������ �� �������� �� ������ �������,* ��� ��� ������ ������ ���������� ������ "
				+ "����������. � ��������� ���������� ������� �� �����. *";
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
	 * " ").replaceAll("[^\\sa-zA-Z�-��-�]", "")); }
	 */

}

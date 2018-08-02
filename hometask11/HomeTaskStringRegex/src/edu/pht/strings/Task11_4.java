package edu.pht.strings;

public class Task11_4 {

	public static void main(String[] args) {
		String text = "�������� �������� StringBuilder �� StringBuffer �������� ������������������ ����������. "
				+ "����� ������� �������� ��������� ���� ��������� ���������� ������������������ ������ "
				+ "StringBuilder. ��� ������� ���������, ���� �� ���������� ����������� ������������� "
				+ "������� � ������������� �������";
		String substring = "(�� ������ �������������� ������ � ������ String, �� � ������� �� ���������� "
				+ "���������� � ������� �������� ������� ����� ��������) ";
		int k = 48;
		System.out.println(text.substring(0, k) + substring + text.substring(k));
		System.out.println("�������: ");
		StringBuilder builder = new StringBuilder(text).insert(k, substring);
		System.out.println(builder.toString());

	}
}

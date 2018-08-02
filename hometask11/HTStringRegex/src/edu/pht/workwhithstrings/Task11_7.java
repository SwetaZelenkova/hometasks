package edu.pht.workwhithstrings;

public class Task11_7 {

	public static void main(String[] args) {

		String text = "{public static void  main(String[ ] args) { String input = \"abdcxyz\";"
				+ "simpleMatches          (\"([a-z]*)([a-z]+)\",          input);"
				+ "simpleMatches          (\"([a-z]?)([a-z]+)\",          input);"
				+ "simpleMatches          (\"([a-z]+)([a-z]*)\",          input);"
				+ "simpleMatches          (\"([a-z]?)([a-z]?)\",          input);}";
		System.out.println(text.replaceAll("[^\\sa-zA-Zа-яА-ЯёЁ]", ""));

	}
}

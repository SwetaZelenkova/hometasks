package edu.pht.regexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegExp {

	public static final String REGEXP1 = ".{4}";
	public static final String REGEXP2 = "[a-zA-Z]";

	public static void main(String[] args) {
		List<String> listStringsToValidate = new ArrayList<>(Arrays
				.asList(new String[] { "  l99a+n00a__", "nika.benz@list.ru", "zelenkova-sveta@bk.ru", "me____-@.ru",
						"some..@.  ", "0__________@998.ru", "WCc", "00&_", "___777@mail.^^", "w@#/", "9-='", "w&w%w@" }));
		Pattern pattern = Pattern.compile(REGEXP1);
		Matcher matcher;
		for (int i = 0; i < listStringsToValidate.size(); i++) {
			matcher = pattern.matcher(listStringsToValidate.get(i));
			if (matcher.matches()) {
				System.out.println(listStringsToValidate.get(i));
			}
		}
		System.out.println("_____________________________________________________");
		
		/*1.	Написать регулярное выражение, 
		 * которое проверит, что в заданной строке 
		 * содержится не более 4-х букв латинского алфавита - "[A-Za-z]{0,4}" -
		 * для решения этой задачи не могу использовать*/
		System.out.println("_____________________________________________________");
		
		Pattern pt = Pattern.compile(REGEXP2);
		Matcher mt;
		for (int i = 0; i < listStringsToValidate.size(); i++) {
			int count = 0;
			mt = pt.matcher(listStringsToValidate.get(i));
			while (mt.find()) {
				count += 1;
			}
			if (count <= 4) {
				System.out.println(listStringsToValidate.get(i));
			}
		}
	}
}

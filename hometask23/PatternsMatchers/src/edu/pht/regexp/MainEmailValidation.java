package edu.pht.regexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainEmailValidation {
	private static final String REGEXP = "^(([a-zA-Z0-9])+([.\\w\\-]+)*([a-zA-Z0-9])+@(mail.ru|inbox.ru|list.ru|bk.ru))$";

	/*
	 * При регистрации на mail.ru сообщение:
	 * 
	 * Допустимо использовать только латинские буквы, цифры, знак подчеркивания
	 * («_»), точку («.»), минус («-»)
	 * 
	 * Имя должно начинаться с латинской буквы (a‑z) или цифры (0‑9)
	 * 
	 * Имя должно заканчиваться на латинскую букву (a‑z) или цифру (0‑9)
	 * 
	 * В имени почтового ящика нельзя использовать кириллицу
	 * 
	 * Домены: @mail.ru, @inbox.ru, @list.ru, @bk.ru
	 */
	public static void main(String[] args) {
		List<String> listOfEmailsToValidate = new ArrayList<>(Arrays.asList(new String[] { "lana_zelenkova@tut.by",
				"nika.benz@list.ru", "zelenkova-sveta@bk.ru", "some____-@mail.ru", "some.some.@mail.ru",
				"0__________@mail.ru", "000mail.ru", "___777@mail.ru", "www@inbox.ru" }));
		Pattern pattern = Pattern.compile(REGEXP);
		Matcher matcher;
		for (int i = 0; i < listOfEmailsToValidate.size(); i++) {
			matcher = pattern.matcher(listOfEmailsToValidate.get(i));
			if (matcher.find()) {
				System.out.println(listOfEmailsToValidate.get(i) + " is valid for registration in https://mail.ru");
			}
		}
	}

}

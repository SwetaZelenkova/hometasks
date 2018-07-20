package edu.pht.wordhandler;

public final class Constants {
	
	final static String NOTN = "это не число! ";
	final static String NOTNULL = "введите порядковый номер буквы к замене, не ноль! ";
	final static String N = "Введите положительное число - какую по счету букву меняем: ";
	final static String CH = "Введите символ, на который заменим данную по счету букву в каждом слове: ";
	final static String INPUT = " Введите Ваш текст. По окончании ввода отдельной строкой введите + ";
	final static String PATH = "Введите имя файла - абсолютный путь к уже существующему файлу: ";
	final static String NOTPATH = "Файл не существует. Проверьте на корректность указанный путь: ";
	final static String START = "Файл с таким именем существует. Процесc запущен... ";
	final static String E = "Прописывайте полный путь к файлу, с указанием имени и расширения ";
	final static String EMPTY = "";
	final static String PLUS = "+";
	final static String SPACE = " ";
	final static String DOT = ".";
	final static String REGEX_FOR_PARAGRAPHS = "\\r?\\n\\t";
	final static String REGEX_FOR_CLAUSES = "[.?!]";
	final static String REGEX_FOR_WORDS = "[ :;,()-]";
	final static String FILE_WITH_NEWCHAR = "params.properties";
	private Constants() {
	}

}

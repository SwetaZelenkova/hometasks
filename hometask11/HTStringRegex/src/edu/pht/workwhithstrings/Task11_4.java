package edu.pht.workwhithstrings;

public class Task11_4 {

	public static void main(String[] args) {

		String text = "Основным отличием StringBuilder от StringBuffer является потокобезопасность последнего. "
				+ "Более высокая скорость обработки есть следствие отсутствия потокобезопасности класса "
				+ "StringBuilder. Его следует применять, если не существует вероятности использования "
				+ "объекта в конкурирующих потоках";
		String substring = "(по своему предназначению близки к классу String, но в отличие от последнего "
				+ "содержимое и размеры объектов классов можно изменять) ";
		int k = 48;
		System.out.println(text.substring(0, k) + substring + text.substring(k));
		System.out.println("Вариант: ");
		StringBuilder builder = new StringBuilder(text).insert(k, substring);
		System.out.println(builder.toString());

	}

}

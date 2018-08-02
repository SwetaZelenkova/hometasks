package edu.pht.strings;

public class Task11_4 {

	public static void main(String[] args) {
		String text = "ќсновным отличием StringBuilder от StringBuffer €вл€етс€ потокобезопасность последнего. "
				+ "Ѕолее высока€ скорость обработки есть следствие отсутстви€ потокобезопасности класса "
				+ "StringBuilder. ≈го следует примен€ть, если не существует веро€тности использовани€ "
				+ "объекта в конкурирующих потоках";
		String substring = "(по своему предназначению близки к классу String, но в отличие от последнего "
				+ "содержимое и размеры объектов классов можно измен€ть) ";
		int k = 48;
		System.out.println(text.substring(0, k) + substring + text.substring(k));
		System.out.println("¬ариант: ");
		StringBuilder builder = new StringBuilder(text).insert(k, substring);
		System.out.println(builder.toString());

	}
}

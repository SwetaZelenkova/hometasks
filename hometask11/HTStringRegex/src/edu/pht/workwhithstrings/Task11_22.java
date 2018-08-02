package edu.pht.workwhithstrings;

public class Task11_22 {

	public static void main(String[] args) {

		String text = "public static void main(String[] args) {\r\n" + "" + "      /**\r\n"
				+ "		 * И ЗДЕСЬ КОММЕНТИМ И ТУТ\r\n" + "		 * \r\n" + "		 * И ТАМ\r\n" + "		 */\r\n"
				+ "		String[] names = { \"c\", \"ccd\", \"ddc\", \"dkk\", \"cd\", \"ccccdddd\", \"dddddddddddd\" };\r\n"
				+ "		//\r\n"
				+ "		List<String> list = Arrays.asList(names).stream().map(name -> name.replace('c', '#'))\r\n"
				+ "				.collect(Collectors.toList());\r\n"
				+ "		System.out.println(list);//ЗДЕСЬ МОЖЕТ БЫТЬ ЧТО-ТО ПРОКОММЕНТИРОВАНО\r\n"
				+ "		// найти все эл массива, начинающиеся с заданной буквы\r\n"
				+ "		List<String> listNew = Arrays.asList(names).stream().filter(name -> (name.startsWith(\"c\")))\r\n"
				+ "				.collect(Collectors.toList());\r\n"
				+ "		  System.out.println(listLength);/*System.out.println(listNew);*/\r\n"
				+ "		// для каждого эл массива заменить любую заданную букву на #\r\n"
				+ "		List<String> listNewNew = Arrays.asList(names).stream().map(name -> name.replaceAll(\"d\", \"#\"))\r\n"
				+ "				.collect(Collectors.toList());\r\n"
				+ "//КОММЕНТА МОГУТ БЫТЬ В ЛЮБОМ МЕСТЕ - System.out.println(listNewNew);\r\n"
				+ "		// для каждого эл массива удалить последнюю букву;\r\n"
				+ "		List<String> listDelLastLetter = Arrays.asList(names).stream()\r\n"
				+ "				.map(name -> name.replace(name.charAt(name.length() - 1), ' ')).collect(Collectors.toList());\r\n"
				+ "		System.out.println(listDelLastLetter);//КОММЕНТЫ МОГУТ БЫТЬ В ЛЮБОМ МЕСТЕ - System.out.println(listNewNew);\r\n"
				+ "		List<String> listDelLastLetterII = Arrays.asList(names).stream()\r\n"
				+ "				.map(name -> name.substring(0, name.length() - 1)).collect(Collectors.toList());\r\n"
				+ "		System.out.println(listDelLastLetterII);\r\n"
				+ "		// найти все эл массива, длина которых больше 1;//КОММЕНТЫ МОГУТ БЫТЬ В ЛЮБОМ МЕСТЕ - System.out.println(listNewNew);\r\n"
				+ "		List<String> listLength = Arrays.asList(names).stream().filter(name -> name.length() > 3)\r\n"
				+ "				.collect(Collectors.toList());\r\n"
				+ "		/*System.out.println(listLength);*/  System.out.println(listLength);/*System.out.println(listNew);*/\r\n"
				+ "		// для каждого элемента массива первую и последнюю букву заменить\r\n"
				+ "		System.out.println(Arrays.asList(names).stream()\r\n"
				+ "				.map(name -> name.replaceFirst(\"^[a-zA-Z]\", \"*\").replaceFirst(\"[a-zA-Z]$\", \"&\"))\r\n"
				+ "				.collect(Collectors.toList()));";
		text = text.replace("//", "\n//").replace("/*", "\n/*").replace("*/", "*/\n");
		String[] parts = text.split("\n");
		System.out.println(" До удаления комментариев---------------------------------------------------------------------------------------------");
		for (String toPrint : parts) {
			System.out.println(toPrint);
		}
		for (int i = 0; i < parts.length; i++) {
			parts[i] = parts[i].trim();
			if ((parts[i].length() >= 2
					&& ((parts[i].charAt(0) == '/' && parts[i].charAt(1) == '/')
							|| (parts[i].charAt(0) == '/' && parts[i].charAt(1) == '*')
							|| (parts[i].charAt(0) == '*' && parts[i].charAt(1) == '/')))
					|| (!parts[i].isEmpty() && parts[i].charAt(0) == '*')) {
				parts[i] = "";
			}
		}
		System.out.println(" После удаления комментариев-----------------------------------------------------------------------------------------");
		for (String toPrint : parts) {
			System.out.println(toPrint);
		}
	}
}

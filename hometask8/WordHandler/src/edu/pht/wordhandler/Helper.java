package edu.pht.wordhandler;

import java.io.File;
import java.util.Scanner;

public class Helper {
	
	private static String absolutePath;
	
	public static int getIndex(Scanner scanner) {
		System.out.println(Constants.N);
		int number;
		do {
			while (!scanner.hasNextInt()) {
				System.out.println(Constants.NOTN);
				scanner.next();
			}
			number = scanner.nextInt();
			if (number == 0) {
				System.out.println(Constants.NOTNULL);
			}
		} while (number <= 0);
		return number;
	}

	public static String getFileName(Scanner scanner) {
		scanner = new Scanner(System.in);
		File file;
		System.out.println(Constants.PATH);
		do  {
			absolutePath = scanner.nextLine();
			file = new File(absolutePath);
			if (!file.exists()) {
				System.out.println(Constants.NOTPATH + absolutePath );
			}
		} while(!file.exists());
		System.out.println(Constants.START);
		return absolutePath;
	}
}

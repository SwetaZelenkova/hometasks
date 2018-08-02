package edu.pht.excs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader implements AutoCloseable {

	private Scanner scanner;

	public Reader(String fileName) throws FileNotFoundException {
		scanner = new Scanner(new File(fileName));
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void close() {
		scanner.close();
	}

	public String readWithSC() throws FileNotFoundException {
		StringBuffer result = new StringBuffer();
		while (scanner.hasNext()) {
			result.append(scanner.nextLine()).append("\n");
		}
		return result.toString();
	}
}

package edu.pht.wordhandler;

import java.util.Scanner;

public class ReaderFromConsole implements IReader{

	private Scanner scanner;
	private String text;
	
	public ReaderFromConsole() {
		this.scanner = new Scanner(System.in);
		this.text = Constants.EMPTY;
	}

	@Override
	public Scanner getScanner() {
		return scanner;
	}

	public String getText() {
		return text;
	}

	@Override
	public void read() {
		System.out.println(Constants.INPUT);
		String result = Constants.EMPTY;
		String input;
		do {
			input = scanner.nextLine();
			input = input.replaceAll("\\s+", Constants.SPACE);
			result += input;
		} while (!input.trim().equals(Constants.PLUS));
		text = result;
	}

	@Override
	public void print() {
		System.out.println("Ваш текст: " + text);
	}

	@Override
	public void close() {
		scanner.close();
	}

	@Override
	public String get() {
		text = text.replace(Constants.PLUS, Constants.EMPTY);
		return text;
	}
}

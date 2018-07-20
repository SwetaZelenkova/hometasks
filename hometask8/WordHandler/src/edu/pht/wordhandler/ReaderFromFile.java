package edu.pht.wordhandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReaderFromFile implements IReader {
	
	private final String fileName;

	private Scanner scanner;
	private String text;
	
	public ReaderFromFile(String fileName) {
		this.scanner = new Scanner(System.in);
		this.text = Constants.EMPTY;
		this.fileName = fileName;
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
		String result = Constants.EMPTY;
		String line;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            while ((line = reader.readLine()) != null) {
            	result += line + "\n";
            }
		} catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(Constants.E);
        } catch (IOException e) {
        	System.out.println(e.getMessage());
        }
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

	/*@Override
	public void read() {
		StringBuffer result = new StringBuffer();
        try {
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
            	result.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		text = result.toString();
	}*/
}

package edu.pht.wordhandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) {
		IReader rfc = new ReaderFromConsole();
		rfc.read();
		rfc.print();
		IHandler wh = new TextHandler();
		int n = Helper.getIndex(rfc.getScanner());
		Paragraph text = new Paragraph(rfc.get());
		Properties props = new Properties(); 
		try {
			props.load(new FileInputStream(Constants.FILE_WITH_NEWCHAR));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		char newChar = props.getProperty("NEW_CHAR").charAt(0);
		for (IData cl : text.getListClause()) {
			wh.setData(new Clause(cl.toString()));
			wh.replace(n, newChar);
			System.out.println(wh.getData());
		}
		String fileName = Helper.getFileName(rfc.getScanner());
		ReaderFromFile rff = new ReaderFromFile(fileName);
		rff.read();
		rff.print();
		n = Helper.getIndex(rfc.getScanner());
		Paragraph textFromFile = new Paragraph(rff.get());
		for (IData cl : textFromFile.getListClause()) {
			wh.setData(new Clause(cl.toString()));
			wh.replace(n, newChar);
			System.out.println(wh.getData());
		}
		rfc.close();
	}

}

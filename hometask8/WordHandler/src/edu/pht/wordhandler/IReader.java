package edu.pht.wordhandler;

import java.util.Scanner;

public interface IReader {
	
	String get();
	void read();
	void print();
	void close();
	Scanner getScanner();

}

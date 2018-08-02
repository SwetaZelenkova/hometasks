package edu.pht.excs;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Writer implements AutoCloseable {

	private BufferedWriter writer;

	public Writer(String fileName) throws FileNotFoundException {
		this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
	}

	public void writeWithBR(Massive massive) throws IOException {
		for (int i = 0; i <= massive.defineLastIndex(); i++) {
			writer.write(massive.getMassive()[i] + "\n");
		}
	}

	@Override
	public void close() throws IOException {
		if (writer != null) {
			writer.close();
		}
	}

	public void writeWithBR(House[] house) throws IOException {
		for (int i = 0; i < house.length; i++) {
			writer.write(house[i] + "\n");
		}
	}

}

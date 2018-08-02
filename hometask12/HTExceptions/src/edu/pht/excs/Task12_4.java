package edu.pht.excs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;

import edu.pht.excs.House.HouseType;

public class Task12_4 {

	private final static String A_FILE = "addressData.txt";
	private final static String H_FILE = "houseData.txt";
	private final static String T_FILE = "test.txt";

	public static void main(String[] args) {
		int n = 10;
		System.out.println(" Size: " + n);
		Massive massive = new Massive(n);
		try (Reader readerA = new Reader(A_FILE); Reader readerH = new Reader(H_FILE)) {
			String addressData = readerA.readWithSC();
			String houseData = readerH.readWithSC();
			try {
				String[] dataAParts = addressData.split("\n");
				String[] dataHParts = houseData.split("\n");
				NumberFormat nf = NumberFormat.getInstance();
				for (int i = 0; i < dataAParts.length; i++) {
					String[] dataA = dataAParts[i].split(" ");
					Address address = new Address(dataA[0], dataA[1], dataA[2], Integer.parseInt(dataA[3]));
					String[] dataH = dataHParts[i].split(" ");
					House house = new House(nf.parse(dataH[0]).longValue(), HouseType.valueOf(dataH[1]),
							nf.parse(dataH[2]).intValue(), nf.parse(dataH[3]).intValue(), address,
							nf.parse(dataH[4]).intValue());
					massive.getMassive()[i] = house;
					System.out.println(" Full info: " + massive.getMassive()[i]);
					System.out.println();
				}
			} catch (ParseException | NumberFormatException e) {
				System.out.println("...write down the correctly numbers in file, please. /" + e.getMessage());
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(
						"...write down the correctly furmula for size calculation, please. /" + e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("...write down the correctly filename, please. /" + e.getMessage());
		}
		System.out.println();
		House[] houseWithDiscount = null;
		try {
			houseWithDiscount = massive.getHouseWithDiscount();
		} catch (NoSuchHouseException e) {
			System.out.println(e.getMessage());
		}
		if (houseWithDiscount != null) {
			for (int i = 0; i < houseWithDiscount.length; i++) {
				System.out.println(houseWithDiscount[i]);
			}
		} else {
			System.out.println("...data not found");
		}
		Writer writer = null;
		try {
			writer = new Writer(T_FILE);
			writer.writeWithBR(houseWithDiscount);
		} catch (FileNotFoundException e) {
			System.out.println("...file not found");
		} catch (IOException e) {
			System.out.println("...error input/output");
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("...error input/output");
				}
			}
		}
	}

}

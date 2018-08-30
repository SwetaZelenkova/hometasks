package edu.pht.excs;

import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;

import edu.pht.excs.House.HouseType;

public class Task12_3 {

	private final static String A_FILE = "addressData.txt";
	private final static String H_FILE = "houseData.txt";

	public static void main(String[] args) {

		int n = (int) (Math.random() * 100 - 9);
		System.out.println(" Size: " + n);
		Massive massive;
		try {
			massive = new Massive(n);
		} catch (NegativeArraySizeException e) {
			massive = new Massive();
			System.out.println("...in the issue incorrect formula for size calculation");
		}
		try (Reader readerA = new Reader(A_FILE); Reader readerH = new Reader(H_FILE)) {
			String addressData = readerA.readWithSC();
			String houseData = readerH.readWithSC();

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
		} catch (ParseException | NumberFormatException | ArrayIndexOutOfBoundsException | FileNotFoundException e) {
			String detailsMessage = "";
			if (e instanceof ArrayIndexOutOfBoundsException) {
				detailsMessage = " undersized of data - 10 ArrayIndexOutOfBoundsException ";
			} else if (e instanceof ParseException) {
				detailsMessage = " ParseException ";
			} else if (e instanceof NumberFormatException) {
				detailsMessage = " NumberFormatException ";
			} else {
				detailsMessage = " FileNotFoundException ";
			}
			System.out.println("...error /" + e.getMessage() + detailsMessage);
		}

	}

}

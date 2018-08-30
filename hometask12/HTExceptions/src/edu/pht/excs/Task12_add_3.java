package edu.pht.excs;

public class Task12_add_3 {

	public static void main(String[] args) {
		int n = (int) (Math.random() * 100 - 9);
		System.out.println(" Size: " + n);
		Massive massive = null;
		try {
			System.exit(0);
			massive = new Massive(n);

		} catch (NegativeArraySizeException e) {
			massive = new Massive();
			System.out.println("...in the issue incorrect formula for size calculation");
		} finally {
			System.out.println(massive);
		}

	}

}

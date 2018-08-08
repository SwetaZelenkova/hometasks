package edu.pht.junittests;

public class Main {

	public static void main(String[] args) {
		int[] array = new int[11];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) Math.round(Math.random() * 100);
		}
		Massive massive = new Massive(array);
		System.out.println(massive.print(array));
		System.out.println("\nIndex: " + massive.getMiddleIndex());
		System.out.println(massive.sumAllElements());
		System.out.println(massive.productAllElements());
		System.out.println(massive.getMinElement());
		System.out.println(massive.getMaxElement());
		int[] result = massive.revert();
		System.out.println(massive.print(result));
		result = massive.insertingSort();
		System.out.println(massive.print(result));
		System.out.println(massive.print(massive.revert()));
		result = massive.bubbleSort();
		System.out.println(massive.print(result));
	}

}

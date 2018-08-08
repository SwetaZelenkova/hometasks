package edu.pht.junittests;

public class Massive {

	private int middleIndex;
	private int[] massive;

	public Massive() {
	}

	public Massive(int[] massive) {
		this.massive = massive;
		int size = massive.length;
		if (size % 2 == 0) {
			this.middleIndex = size / 2;
		} else {
			this.middleIndex = (size - 1) / 2;
		}
	}

	public Massive(int middleIndex, int[] massive) {
		this.middleIndex = middleIndex;
		this.massive = massive;
	}

	public int getMiddleIndex() {
		return middleIndex;
	}

	public void setMiddleIndex(int middleIndex) {
		this.middleIndex = middleIndex;
	}

	public int[] getMassive() {
		return massive;
	}

	public void setMassive(int[] massive) {
		this.massive = massive;
	}

	public int sumAllElements() {
		int result = 0;
		for (int i = 0; i < massive.length; i++) {
			result += massive[i];
		}
		return result;
	}

	public long productAllElements() {
		long result = 1;
		for (int i = 0; i < massive.length; i++) {
			result *= massive[i];
		}
		return result;
	}

	public int getMinElement() {
		int min = massive[0];
		for (int i = 1; i < massive.length; i++) {
			if (massive[i] < min) {
				min = massive[i];
			}
		}
		return min;
	}

	public int getMaxElement() {
		int max = massive[0];
		for (int i = 1; i < massive.length; i++) {
			if (massive[i] > max) {
				max = massive[i];
			}
		}
		return max;
	}

	public int[] revert() {
		int temp;
		for (int i = 0, j = massive.length - 1; i < j; i++, j--) {
			temp = massive[i];
			massive[i] = massive[j];
			massive[j] = temp;
		}
		return massive;
	}

	public int[] bubbleSort() {
		int temp;
		for (int i = 0; i < massive.length; i++) {
			for (int j = 0; j < massive.length - i - 1; j++) {
				if (massive[j] > massive[j + 1]) {
					temp = massive[j];
					massive[j] = massive[j + 1];
					massive[j + 1] = temp;
				}
			}
		}
		return massive;
	}

	public int[] insertingSort() {
		int temp;
		for (int i = 1; i < massive.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (massive[j] > massive[j + 1]) {
					temp = massive[j];
					massive[j] = massive[j + 1];
					massive[j + 1] = temp;
				}
			}
		}
		return massive;
	}

	public boolean containsNegativeNumbers() {
		for (int i = 0; i < massive.length; i++) {
			if (massive[i] < 0) {
				return true;
			}
		}
		return false;
	}

	public String print(int[] toPrint) {
		String result = "";
		if (toPrint != null) {
			for (int i = 0; i < toPrint.length; i++) {
				result += String.valueOf(toPrint[i]) + "|";
			}
		} else {
			throw new IllegalArgumentException();
		}
		return result;
	}
}

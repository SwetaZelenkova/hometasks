package edu.pht.excs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Massive {
	private int size;
	private House[] massive;
	private int lastIndex;
	private House headElement;

	public Massive() {
		this.size = 10;
		this.massive = new House[10];
		System.out.println(" ...created array with default size = 10");
	}

	public Massive(int size) throws NegativeArraySizeException {
		if (size > 0) {
			this.size = size;
			this.massive = new House[size];
			System.out.println(" ...created array with size = " + this.size);
		} else {
			throw new NegativeArraySizeException();
		}
	}

	public Massive(House[] massive) {
		this.size = massive.length;
		this.massive = new House[this.size];
		for (int i = 0; i < this.size; i++) {
			this.massive[i] = massive[i];
		}
		this.lastIndex = this.size - 1;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public House[] getMassive() {
		return massive;
	}

	public void setMassive(House[] massive) {
		this.massive = massive;
	}

	public int getLastIndex() {
		return defineLastIndex();
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public House getHeadElement() {
		return headElement;
	}

	public void setHeadElement(House headElement) {
		this.headElement = headElement;
	}

	public int defineLastIndex() {
		int countNotNullElement = 0;
		for (int i = 0; i < massive.length; i++) {
			if (massive[i] != null) {
				countNotNullElement++;
			}
		}
		int lastIndex = countNotNullElement - 1;
		return lastIndex;
	}

	public House getLastHouse() {
		return massive[defineLastIndex()];
	}

	public int getDiscount(int price) {
		return price * 10 / 100;
	}

	public House[] getHouseWithDiscount() throws NoSuchHouseException {
		List<House> result = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (massive[i] != null && massive[i].getRoom() >= 8 && massive[i].getPrice() >= 70000) {
				massive[i].setPrice(massive[i].getPrice() - getDiscount(massive[i].getPrice()));
				result.add(massive[i]);
			}
		}
		if (result.isEmpty()) {
			throw new NoSuchHouseException("...house with discount is not found");
		}
		return result.toArray(new House[result.size()]);
	}

	public House[] getHouseInCA() throws NoSuchHouseException {
		List<House> result = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (massive[i] != null && massive[i].getAddress().getState().toUpperCase().equals("CA")) {
				result.add(massive[i]);
			}
		}
		if (result.isEmpty()) {
			throw new NoSuchHouseException("...house in CA is not found");
		}
		return result.toArray(new House[result.size()]);
	}

	public House defineHeadElement() throws ReturnNullException {
		House headElement;
		if (massive != null) {
			headElement = massive[0];
			for (int i = 1; i < massive.length; i++) {
				if (massive[i] != null && (massive[i].getPrice() > headElement.getPrice())) {
					headElement = massive[i];
				}
			}
		} else {
			throw new ReturnNullException("...massive of houses is not exist...wrong calculate length of massive");
		}
		return headElement;
	}

	@Override
	public String toString() {
		return "Massive [size=" + size + ", massive=" + Arrays.toString(massive) + ", lastIndex=" + lastIndex
				+ ", headElement=" + headElement + "]";
	}
}

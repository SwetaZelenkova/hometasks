package edu.pht.collections.entity;

import java.util.List;

public class Dropdown implements Comparable<Dropdown> {

	private List<String> options;
	private boolean isSelected;
	private String name;

	public Dropdown(List<String> options, boolean isSelected, String name) {
		this.options = options;
		this.isSelected = isSelected;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isSelected ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (getClass() != o.getClass() || o == null)
			return false;

		Dropdown that = (Dropdown) o;

		if (isSelected != that.isSelected)
			return false;
		if (this.name != null ? !this.name.equals(that.name) : that.name != null)
			return false;
		if (this.options != null ? !this.options.equals(that.options) : that.options != null)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dropdown | options = " + options + ", isSelected = " + isSelected + ", name = " + name + " | \n";
	}

	@Override
	public int compareTo(Dropdown that) {
		int result = this.name.compareTo(that.name);
		if (result != 0) {
			return result / Math.abs(result);
		}
		return 0;
	}
}

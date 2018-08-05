package edu.pht.collections.entity;

public class Label implements Comparable<Label> {

	private String name;

	public Label(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (getClass() != o.getClass() || o == null)
			return false;

		Label that = (Label) o;

		if (this.name != null ? !this.name.equals(that.name) : that.name != null)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Label | name = " + name + " | \n";
	}

	@Override
	public int compareTo(Label that) {
		int result = this.name.compareTo(that.name);
		if (result != 0) {
			return result / Math.abs(result);
		}
		return 0;
	}
}

package edu.pht.collections.entity;

public class Field implements Comparable<Field> {

	private long id;
	private String value;

	public Field(long id, String value) {

		this.id = id;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == 0 ? 0 : Long.valueOf(id).hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (this.getClass() != o.getClass() || o == null)
			return false;

		Field that = (Field) o;

		if (this.id != that.id)
			return false;
		if (this.value != null ? !this.value.equals(that.value) : that.value != null)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Field | id = " + id + ", value = " + value + " | \n";
	}

	@Override
	public int compareTo(Field o) {
		if (this.id == o.id) {
			return 0;
		} else if (this.id < o.id) {
			return -1;
		} else {
			return 1;
		}
	}

}

package edu.pht.collections.entity;

public class Button implements Comparable<Button> {

	private String name;
	private String action;

	public Button(String name, String action) {
		this.name = name;
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public String getAction() {
		return action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Button that = (Button) o;

		if (name != null ? !name.equals(that.name) : that.name != null)
			return false;
		if (action != null ? !action.equals(that.action) : that.action != null)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Button | name = " + name + ", action = " + action + " | \n";
	}

	@Override
	public int compareTo(Button o) {
		int result = this.name.compareTo(o.name);
		if (result != 0) {
			return result / Math.abs(result);
		}
		return 0;
	}
}

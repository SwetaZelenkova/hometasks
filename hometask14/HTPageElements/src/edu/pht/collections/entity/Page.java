package edu.pht.collections.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import edu.pht.collections.exception.InvalidActionException;
import edu.pht.collections.exception.NoSuchEntityException;

public class Page {

	private ArrayList<Button> buttons;
	private LinkedList<Field> fields;
	private HashSet<Label> labels;
	private TreeSet<Dropdown> dropdowns;
	private float id;
	private String title;

	public Page() {

	}

	public Page(ArrayList<Button> buttons, LinkedList<Field> fields, HashSet<Label> labels, TreeSet<Dropdown> dropdowns,
			float id, String title) {
		this.buttons = buttons;
		this.fields = fields;
		this.labels = labels;
		this.dropdowns = dropdowns;
		this.id = id;
		this.title = title;
	}

	public TreeSet<Dropdown> getDropdowns() {
		return dropdowns;
	}

	public void setButtons(ArrayList<Button> buttons) {
		this.buttons = buttons;
	}

	public void setFields(LinkedList<Field> fields) {
		this.fields = fields;
	}

	public void setLabels(HashSet<Label> labels) {
		this.labels = labels;
	}

	public void setDropdowns(TreeSet<Dropdown> dropdowns) {
		this.dropdowns = dropdowns;
	}

	public void setId(float id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean containsButton(Button button) {
		if (buttons.contains(button)) {
			return true;
		}
		return false;
	}

	public Field getFirstField() throws NoSuchEntityException {
		if (fields.size() == 0) {
			throw new NoSuchEntityException("field element not found", "list of fields is empty");
		}
		return fields.getFirst();
	}

	public Field getLastField() throws NoSuchEntityException {
		if (fields.size() == 0) {
			throw new NoSuchEntityException("field element not found", "list of fields is empty");
		}
		return fields.getLast();
	}

	public HashSet<Label> addAllLabels(Label[] labels) {
		this.labels.addAll(Arrays.asList(labels));
		return this.labels;
	}

	public void in(ArrayList<Label> labels) throws InvalidActionException {
		if (!Dropdown.class.isAssignableFrom(labels.get(0).getClass())) {// Label.class
			throw new InvalidActionException("collection element must extends class Dropdown",
					"this is a unvailable action");
		}
	}

	public LinkedHashSet<Dropdown> getElementsDropdown() {
		LinkedHashSet<Dropdown> setDropdowns = new LinkedHashSet<>(dropdowns);
		String className = dropdowns.getClass().getName();
		String type = className.substring(className.length() - 3).toLowerCase();
		// System.out.println(type);
		if (type.equals("set")) {
			try {
				throw new NoSuchEntityException("the saved third can not be found for set",
						"to store the order of the elements use list");
			} catch (NoSuchEntityException e) {
				System.out.println(e.getMessage());
			}
		} else {
			int count = 0;
			if (dropdowns != null && dropdowns.size() >= 3) {
				for (Dropdown element : dropdowns) {
					count++;
					if (count == 3) {
						System.out.println("stored third: " + element);
					}
				}
			}
		}
		return setDropdowns;
	}

	public int compareLabels(Label l1, Label l2) {
		String name1 = l1.getName();
		String name2 = l2.getName();
		int result = name1.compareTo(name2);
		if (result != 0) {
			return result / Math.abs(result);
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buttons == null) ? 0 : buttons.hashCode());
		result = prime * result + ((dropdowns == null) ? 0 : dropdowns.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + Float.floatToIntBits(id);
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (buttons == null) {
			if (other.buttons != null)
				return false;
		} else if (!buttons.equals(other.buttons))
			return false;
		if (dropdowns == null) {
			if (other.dropdowns != null)
				return false;
		} else if (!dropdowns.equals(other.dropdowns))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (Float.floatToIntBits(id) != Float.floatToIntBits(other.id))
			return false;
		if (labels == null) {
			if (other.labels != null)
				return false;
		} else if (!labels.equals(other.labels))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Page | id = " + id + ", title = " + title + "\nbuttons = " + buttons + "\nfields = " + fields
				+ "\nlabels = " + labels + "\ndropdowns = " + dropdowns + " | ";
	}

}

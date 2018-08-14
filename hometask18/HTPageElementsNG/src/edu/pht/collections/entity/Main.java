package edu.pht.collections.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import edu.pht.collections.comparator.SortArrayListButtons;
import edu.pht.collections.comparator.SortLinkedListFields;
import edu.pht.collections.comparator.SortedButtonsByAction;
import edu.pht.collections.comparator.SortedButtonsByName;
import edu.pht.collections.comparator.SortedDropdownsByName;
import edu.pht.collections.exception.InvalidActionException;
import edu.pht.collections.exception.NoSuchEntityException;

public class Main {
	private static final String YES = " - is on the page";
	private static final String NO = " - is not found";
	private static final String EMAIL = "Email";
	private static final String ADDRESS = "Address";
	private static final String NAME = "Name";
	private static final String PHONE = "Phone";
	private static final String CREATE = "create";

	public static void main(String[] args) {

		System.out.println("\ncreating buttons------------------------------\n");
		ArrayList<Button> buttons = initButtons();
		println(buttons);
		System.out.println("\ncreate fields-------------------------------\n");
		LinkedList<Field> fields = initFields();
		println(fields);
		System.out.println("\ncreate labels-------------------------------\n");
		HashSet<Label> labels = initLabels();
		println(labels);
		System.out.println("\ncreate dropdowns----------------------------\n");
		TreeSet<Dropdown> dropdowns = initDropdowns();
		println(dropdowns);
		System.out.println("\ncreating pages--------------------------------\n");
		Page page1 = new Page(buttons, fields, labels, dropdowns, 1, "registration");
		System.out.println(page1);
		System.out.println("\ncontains button-------------------------------\n");
		Button unknown = new Button("to print", "print the page");
		Button isContained = new Button("print", "print the file");
		if (page1.containsButton(isContained)) {
			System.out.println(isContained + YES);
		} else {
			System.out.println(isContained + NO);
		}
		if (page1.containsButton(unknown)) {
			System.out.println(unknown + YES);
		} else {
			System.out.println(unknown + NO);
		}
		System.out.println("\nlabels-in-dropdowns------------------------------\n");
		ArrayList<Label> labs = new ArrayList<>(labels);
		try {
			page1.in(labs);
		} catch (InvalidActionException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nget-first-field----------------------------------\n");
		try {
			System.out.println(page1.getFirstField());
		} catch (NoSuchEntityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nget-last-field-----------------------------------\n");
		try {
			System.out.println(page1.getLastField());
		} catch (NoSuchEntityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nlist-of-fields-is-empty--------------------------\n");
		LinkedList<Field> newFields = new LinkedList<>();
		Page page2 = new Page();
		page2.setFields(newFields);
		System.out.println("\nget-first-field----------------------------------\n");
		try {
			System.out.println(page2.getFirstField());
		} catch (NoSuchEntityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nget-last-field-----------------------------------\n");
		try {
			System.out.println(page2.getLastField());
		} catch (NoSuchEntityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nset-of-dropdowns---------------------------------\n");
		println(page1.getDropdowns());
		try {
			println(page1.getElementsDropdown());
		} catch (NoSuchEntityException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\narray-of-labels-to-set---------------------------\n");
		Label[] arrayLs = { new Label(EMAIL), new Label(EMAIL), new Label(ADDRESS), new Label("Prof"),
				new Label("Hobby"), new Label(EMAIL) };
		println(page1.addAllLabels(arrayLs));
		System.out.println("\ntwo-labels-to-compare----------------------------\n");
		System.out.println(new Label(EMAIL));
		System.out.println(new Label(ADDRESS));
		System.out.println("result " + page1.compareLabels(new Label(EMAIL), new Label(ADDRESS)));
		System.out.println("\ntwo-labels-to-compare----------------------------\n");
		System.out.println(new Label(NAME));
		System.out.println(new Label(PHONE));
		System.out.println("result " + page1.compareLabels(new Label(NAME), new Label(PHONE)));
		System.out.println("\ntwo-labels-to-compare----------------------------\n");
		Label l = new Label("Age");
		System.out.println(l);
		System.out.println(l);
		System.out.println("result " + page1.compareLabels(l, l));
		System.out.println("\nsorting-buttons----------------------------------\n");
		System.out.println("\nshuffle------------------------------------------\n");
		shuffle(buttons);
		System.out.println("\nsorting-with-bubble-sort-------------------------\n");
		ArrayList<Button> sortedButtons = SortArrayListButtons.sort(buttons);
		println(sortedButtons);
		System.out.println("\nshuffle------------------------------------------\n");
		shuffle(buttons);
		System.out.println("\nsorting-with-comparator-by-name------------------\n");
		Collections.sort(buttons, new SortedButtonsByName());
		println(buttons);
		System.out.println("\nshuffle------------------------------------------\n");
		shuffle(buttons);
		System.out.println("\nsorting-with-comparator-by-action----------------\n");
		Collections.sort(buttons, new SortedButtonsByAction());
		println(buttons);
		System.out.println("\nshuffle------------------------------------------\n");
		shuffle(buttons);
		System.out.println("\nsorting-with-comparator-by-name-and-by-action----\n");
		Collections.sort(buttons, new SortedButtonsByName().thenComparing(new SortedButtonsByAction()));
		println(buttons);
		System.out.println("\nsorting-fields-----------------------------------\n");
		System.out.println("\nshuffle------------------------------------------\n");
		shuffle(fields);
		System.out.println("\nsorting-with-inserting-sort-id-------------------\n");
		LinkedList<Field> sortedFieldsById = SortLinkedListFields.sortById(fields);
		println(sortedFieldsById);
		System.out.println("\nshuffle------------------------------------------\n");
		shuffle(fields);
		System.out.println("\nsorting-with-inserting-sort-value----------------\n");
		LinkedList<Field> sortedFieldsByValue = SortLinkedListFields.sortByValue(fields);
		println(sortedFieldsByValue);
	}

	private static <T> void shuffle(List<T> c) {
		Collections.shuffle(c);
		for (T t : c) {
			System.out.println(t);
		}
	}

	private static <T> void println(Collection<T> c) {
		for (T t : c) {
			System.out.println(t);
		}
	}
	
	private static ArrayList<String> arrayToOption(String[] s) {
		return new ArrayList<>(Arrays.asList(s));
	}

	private static ArrayList<Button> initButtons() {
		Button[] arrayButtons = { new Button("save", "save to disk"), new Button("confirm", "go to main page"),
				new Button("log out", "exit"), new Button("cancel", "clean form fields"),
				new Button("print", "print the file"), new Button("convert", "to pdf"),
				new Button(CREATE, "create new page"), new Button(CREATE, "create new window"),
				new Button(CREATE, "create new form"), new Button(CREATE, "create new account") };
		ArrayList<Button> buttons = new ArrayList<Button>(Arrays.asList(arrayButtons));
		return buttons;
	}

	private static LinkedList<Field> initFields() {
		Field[] arrayFields = { new Field(6, "dateBirthfield"), new Field(5, "phonefield"), new Field(1, "textfield"),
				new Field(2, "textarea"), new Field(3, "passwordfield"), new Field(4, "emailfield") };
		LinkedList<Field> fields = new LinkedList<>(Arrays.asList(arrayFields));
		return fields;
	}

	private static HashSet<Label> initLabels() {
		Label[] arrayLabels = { new Label(NAME), new Label("Age"), new Label(PHONE), new Label(ADDRESS),
				new Label(EMAIL), new Label("Comment") };
		HashSet<Label> labels = new HashSet<>(Arrays.asList(arrayLabels));
		return labels;
	}
	
	private static TreeSet<Dropdown> initDropdowns() {
		List<String> options1 = arrayToOption(new String[] {"Jan","Feb","Mar","Apr","May","Jun"});
		Dropdown d1 = new Dropdown(options1, true, "select month");
		List<String> options2 = arrayToOption(new String[] {"male","female"});
		Dropdown d2 = new Dropdown(options2, false, "select gender");
		List<String> options3 = arrayToOption(new String[] {"18 - 31","32 - 44","45+"});
		Dropdown d3 = new Dropdown(options3, true, "Your age");
		List<String> options4 = arrayToOption(new String[] {"Angola","Benin","Lichtenstain"});
		Dropdown d4 = new Dropdown(options4, true, "select country");
		TreeSet<Dropdown> dropdowns = new TreeSet<>(new SortedDropdownsByName());
		dropdowns.add(d1);
		dropdowns.add(d2);
		dropdowns.add(d3);
		dropdowns.add(d4);
		return dropdowns;
	}

}

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
import edu.pht.collections.exception.InvalidActionException;
import edu.pht.collections.exception.NoSuchEntityException;

public class Main {

	public static void main(String[] args) {

		System.out.println("\ncreating buttons------------------------------\n");
		Button b1 = new Button("save", "save to disk");
		Button b2 = new Button("confirm", "go to main page");
		Button b3 = new Button("log out", "exit");
		Button b4 = new Button("cancel", "clean form fields");
		Button b5 = new Button("print", "print the file");
		Button b6 = new Button("to print", "print the page");
		Button b7 = new Button("convert", "to pdf");
		Button b8 = new Button("create", "create new page");
		Button b9 = new Button("create", "create new window");
		Button b10 = new Button("create", "create new form");
		Button b11 = new Button("create", "create new account");
		ArrayList<Button> buttons = new ArrayList<>();
		buttons.add(b1);
		buttons.add(b2);
		buttons.add(b3);
		buttons.add(b4);
		buttons.add(b5);
		buttons.add(b7);
		buttons.add(b8);
		buttons.add(b9);
		buttons.add(b10);
		buttons.add(b11);
		System.out.println(buttons);
		System.out.println("\ncreating fields-------------------------------\n");
		Field[] arrayFields = { new Field(6, "dateBirthfield"), new Field(5, "phonefield"), new Field(1, "textfield"),
				new Field(2, "textarea"), new Field(3, "passwordfield"), new Field(4, "emailfield") };
		LinkedList<Field> fields = new LinkedList<>(Arrays.asList(arrayFields));
		System.out.println(fields);
		System.out.println("\ncreating labels-------------------------------\n");
		Label l1 = new Label("Name");
		Label l2 = new Label("Age");
		Label l3 = new Label("Phone");
		Label l4 = new Label("Address");
		Label l5 = new Label("Email");
		Label l6 = new Label("Comment");
		Label[] arrayLabels = { l1, l2, l3, l4, l5, l6 };
		HashSet<Label> labels = new HashSet<>(Arrays.asList(arrayLabels));
		System.out.println(labels);
		System.out.println("\ncreating dropdowns----------------------------\n");
		List<String> options1 = new ArrayList<>();
		options1.add(0, "Jan");
		options1.add(0, "Feb");
		options1.add(1, "Mar");
		options1.add(0, "Apr");
		options1.add(1, "May");
		options1.add(2, "Jun");
		Dropdown d1 = new Dropdown(options1, true, "select month");
		List<String> options2 = new ArrayList<>();
		options2.add(0, "male");
		options2.add(1, "female");
		Dropdown d2 = new Dropdown(options2, false, "select gender");
		List<String> options3 = new ArrayList<>();
		options3.add(0, "18 - 31");
		options3.add(1, "32 - 44");
		options3.add(2, "45+");
		Dropdown d3 = new Dropdown(options3, true, "Your age");
		List<String> options4 = new ArrayList<>();
		options4.add(0, "Angola");
		options4.add(1, "Benin");
		options4.add(2, "Lichtenstain");
		Dropdown d4 = new Dropdown(options4, true, "select country");
		TreeSet<Dropdown> dropdowns = new TreeSet<Dropdown>();
		dropdowns.add(d1);
		dropdowns.add(d2);
		dropdowns.add(d3);
		dropdowns.add(d4);
		System.out.println(dropdowns);
		System.out.println("\ncreating pages--------------------------------\n");
		Page page1 = new Page(buttons, fields, labels, dropdowns, 1, "registration");
		System.out.println(page1);
		System.out.println("\ncontains button-------------------------------\n");
		if (page1.containsButton(b5)) {
			System.out.println(b5 + " - is on the page");
		} else {
			System.out.println(b5 + " - is not found");
		}
		if (page1.containsButton(b6)) {
			System.out.println(b6 + " - is on the page");
		} else {
			System.out.println(b6 + " - is not found");
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
		println(page1.getElementsDropdown());
		System.out.println("\narray-of-labels-to-set---------------------------\n");
		Label[] arrayLs = { new Label("Email"), new Label("Email"), new Label("Address"), new Label("Prof"),
				new Label("Hobby"), new Label("Email") };
		println(page1.addAllLabels(arrayLs));
		System.out.println("\ntwo-labels-to-compare----------------------------\n");
		System.out.println(l6);
		System.out.println(l4);
		System.out.println("result " + page1.compareLabels(l6, l4));
		System.out.println("\ntwo-labels-to-compare----------------------------\n");
		System.out.println(l1);
		System.out.println(l3);
		System.out.println("result " + page1.compareLabels(l1, l3));
		System.out.println("\ntwo-labels-to-compare----------------------------\n");
		System.out.println(l2);
		System.out.println(l2);
		System.out.println("result " + page1.compareLabels(l2, l2));
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

}

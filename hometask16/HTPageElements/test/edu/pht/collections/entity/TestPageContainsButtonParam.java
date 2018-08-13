package edu.pht.collections.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestPageContainsButtonParam {
	
	private Page page;
	private Button button;
	

	public TestPageContainsButtonParam(Button button) {
		this.button = button;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> arrayButtonsForTest() {
		return Arrays.asList(new Object[][] {
			{new Button("save", "save to disk")}, 
			{new Button("confirm", "go to main page")}, 
			{new Button("log out", "exit")},
			{new Button("cancel", "clean form fields")}, 
			{new Button("create", "create new account")}
		});
	}

	@Before
	public void setUp() throws Exception {
		Button[] buttons = {new Button("save", "save to disk"), 
							new Button("confirm", "go to main page"),
							new Button("log out", "exit"),
							new Button("cancel", "clean form fields"),
							new Button("print", "print the file"),
							new Button("to print", "print the page"),
							new Button("convert", "to pdf"),
							new Button("create", "create new page"),
							new Button("create", "create new window"),
							new Button("create", "create new form"),
							new Button("create", "create new account")};
		ArrayList<Button> buttonsList = new ArrayList<>(Arrays.asList(buttons));
		page = new Page();
		page.setButtons(buttonsList);
	}

	@After
	public void tearDown() throws Exception {
		page = null;
	}

	@Test
	public void testContainsButton() {
		assertTrue(page.containsButton(button));
	}
}

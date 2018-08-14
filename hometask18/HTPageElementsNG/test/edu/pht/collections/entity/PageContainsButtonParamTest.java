package edu.pht.collections.entity;

import org.testng.annotations.Test;

import edu.pht.collections.entity.Button;
import edu.pht.collections.entity.Page;

import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PageContainsButtonParamTest {

	private static Page page;
	private static ArrayList<Button> buttons;

	@Test(dataProvider = "dp")
	public void Page_ContainsButton_Test(Button button, boolean expected) {
		assertEquals(page.containsButton(button), expected);
	}

	@DataProvider(name = "dp")
	public static Object[][] dataForTest() {
		return new Object[][] { { new Button("save", "save to disk"), true },
				{ new Button("write", "write to file"), false }, { new Button("delete", "delete from disk"), true },
				{ new Button("cancel", "clean all fields"), true }, { new Button("password", "enter pass"), false },
				{ new Button("print", "print page"), true } };
	}

	@BeforeClass
	public void beforeClass() {
		page = new Page();
		buttons = new ArrayList<>(Arrays.asList(new Button[] { new Button("save", "save to disk"),
				new Button("delete", "delete from disk"), new Button("cancel", "clean all fields"),
				new Button("print", "print page"), new Button("print", "send to print") }));
		page.setButtons(buttons);
	}

	@AfterClass
	public void afterClass() {
		page = null;
	}

}

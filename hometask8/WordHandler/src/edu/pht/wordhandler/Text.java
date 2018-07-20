package edu.pht.wordhandler;

import java.util.ArrayList;
import java.util.List;

public class Text implements IData {
	
	private String text;
	private List<IData> listParagraph;

	public Text(String text) {
		this.text = text;
		String[] paragraphs = text.split(Constants.REGEX_FOR_PARAGRAPHS);
		listParagraph = new ArrayList<>();
		for (int i = 0; i < paragraphs.length; i++) {
			paragraphs[i] = paragraphs[i].trim();
			if (!paragraphs[i].equals(Constants.EMPTY)) {
				listParagraph.add(new Clause(paragraphs[i]));
			}
		}
	}

	public String getText() {
		return text;
	}

	public List<IData> getListParagraph() {
		return listParagraph;
	}

	@Override
	public List<IData> get() {
		return listParagraph;
	}

	@Override
	public String toString() {
		String result = Constants.EMPTY;
		for (int i = 0; i < listParagraph.size(); i++) {
			result += listParagraph.get(i).toString();
		}
		return result;
	}

	
}

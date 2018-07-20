package edu.pht.wordhandler;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements IData {
	
	private String paragraph;
	private List<IData> listClause;

	public Paragraph(String paragraph) {
		this.paragraph = paragraph;
		String[] clauses = paragraph.split(Constants.REGEX_FOR_CLAUSES);
		listClause = new ArrayList<>();
		for (int i = 0; i < clauses.length; i++) {
			clauses[i] = clauses[i].trim();
			if (!clauses[i].equals(Constants.EMPTY)) {
				listClause.add(new Clause(clauses[i]));
			}
		}
	}

	public String getParagraph() {
		return paragraph;
	}

	public List<IData> getListClause() {
		return listClause;
	}

	@Override
	public List<IData> get() {
		return listClause;
	}

	@Override
	public String toString() {
		String result = Constants.EMPTY;
		for (int i = 0; i < listClause.size(); i++) {
			result += listClause.get(i).toString();
		}
		return result;
	}	
}

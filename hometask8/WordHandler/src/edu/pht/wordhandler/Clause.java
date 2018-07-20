package edu.pht.wordhandler;

import java.util.ArrayList;
import java.util.List;

public class Clause implements IData {
	
	private String clause;
	private List<IData> listWord;
	
	public Clause(String clause) {
		this.clause = clause;
		String[] words = clause.split(Constants.REGEX_FOR_WORDS);
		listWord = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals(Constants.EMPTY)) {
				listWord.add(new Word(words[i]));
			}
		}
	}

	public String getClause() {
		return clause;
	}

	public List<IData> getListWord() {
		return listWord;
	}

	@Override
	public List<IData> get() {
		return listWord;
	}
	
	@Override
	public String toString() {
		String result = Constants.EMPTY;
		for (int i = 0; i < listWord.size(); i++) {
			result += listWord.get(i).toString() + Constants.SPACE;
		}
		return result;
	}
}

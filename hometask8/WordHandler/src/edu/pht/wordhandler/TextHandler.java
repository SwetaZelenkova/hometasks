package edu.pht.wordhandler;

import java.util.List;

public class TextHandler implements IHandler {

	private String dataType;
	private List<IData> data;
	
	enum Type { EDUPHTWORDHANDLERCLAUSE, EDUPHTWORDHANDLERPARAGRAPH, EDUPHTWORDHANDLERTEXT}
	
	public TextHandler() { 
		
	}
	
	@Override
	public void setData(IData data) {
		this.data = data.get();
		this.dataType = data.getClass().getName();
	}
	
	@Override
	public List<IData> getData() {
		return data;
	}
	
	@Override
	public void replace(int index, char newChar) {
		Type typeOfData = Type.valueOf(dataType.replace(Constants.DOT, Constants.EMPTY).toUpperCase());
		switch (typeOfData) {
		case EDUPHTWORDHANDLERCLAUSE: 
			replaceInWord(index, newChar);
			break;
		case EDUPHTWORDHANDLERPARAGRAPH: 
			replaceInClause(index, newChar);
			break;
		case EDUPHTWORDHANDLERTEXT:
			replaceInParagraph(index, newChar);
			break;
		default: 
			throw new EnumConstantNotPresentException(Type.class, dataType);
		};
	}
	private void replaceInWord(int index, char newChar) {
		Word word;
		for (int i = 0; i < data.size(); i++) {
			word = (Word) data.get(i);
			if (word != null && index <= word.getWord().length()) {
				char[] chars = word.getWord().toCharArray();
			    chars[index - 1] = newChar;
			    word.setWord(String.valueOf(chars));
			}
		}
	}
	
	private void replaceInClause(int index, char newChar) {
		throw new UnsupportedOperationException();
	}
	
	private void replaceInParagraph(int index, char newChar) {
		throw new UnsupportedOperationException();
	}
	
}

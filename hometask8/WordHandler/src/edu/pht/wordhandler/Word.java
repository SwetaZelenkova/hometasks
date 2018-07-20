package edu.pht.wordhandler;

import java.util.ArrayList;
import java.util.List;

public class Word implements IData {
	
	private String word;
	
	public Word(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public List<IData> get() {
		List<IData> list = new ArrayList<>();
		list.add(this);
		return list;
	}
	
	@Override
	public String toString() {
		return word;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass() || o == null) return false;

        Word that = (Word) o;

        if (this.word != null ? !this.word.equals(that.word) : that.word != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
}
}

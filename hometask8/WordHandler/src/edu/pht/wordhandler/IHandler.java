package edu.pht.wordhandler;

import java.util.List;

public interface IHandler {
	
	void setData(IData data);
	void replace(int index, char newChar);
	List<IData> getData();
}

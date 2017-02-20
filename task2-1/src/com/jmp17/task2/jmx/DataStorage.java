package com.jmp17.task2.jmx;

import java.util.ArrayList;
import java.util.List;

public class DataStorage implements DataStorageMBean {

	private List<String> data = new ArrayList<String>();
	
	@Override
	public void add(String str) {
		data.add(str);

	}

	@Override
	public String show() {
		StringBuilder s = new StringBuilder();
		for (String string : data) {
			s.append(string).append(";");
		}
		return s.toString();
	}

}

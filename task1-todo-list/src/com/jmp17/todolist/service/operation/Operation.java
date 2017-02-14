package com.jmp17.todolist.service.operation;

import com.jmp17.todolist.exception.UnknownOperationException;

public enum Operation {
	ADD("add"), SHOW("show"), REMOVE("remove"), CLEAR("clear");
	
	private final String key;
	
	private Operation(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	public static Operation fromString(String str) throws UnknownOperationException {
		for(Operation o : Operation.values()) {
			if(o.key.equalsIgnoreCase(str)) {
				return o;
			}
		}
		throw new UnknownOperationException(str);
	}
}

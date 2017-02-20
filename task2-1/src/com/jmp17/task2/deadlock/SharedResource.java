package com.jmp17.task2.deadlock;

public class SharedResource {
	
	private final String name;
	
	public SharedResource(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

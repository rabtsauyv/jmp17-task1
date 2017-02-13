package com.jmp17.todolist.exception;

public class InvalidArgumentsException extends TodoListException {
	private static final String BASE_MESSAGE = "Invalid arguments for '%s' operation: %s";
	
	public InvalidArgumentsException(String operation, String msg) {
		super(String.format(BASE_MESSAGE, operation, msg));
	}
}

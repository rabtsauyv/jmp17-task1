package com.jmp17.todolist.exception;

public class UnknownOperationException extends TodoListException {
	private static final String BASE_MESSAGE = "Unknown operation: ";
	
	public UnknownOperationException(String operation) {
		super(BASE_MESSAGE + operation);
	}
}

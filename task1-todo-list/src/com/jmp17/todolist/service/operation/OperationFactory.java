package com.jmp17.todolist.service.operation;

import java.util.List;

import com.jmp17.todolist.entity.TodoItem;
import com.jmp17.todolist.exception.InvalidArgumentsException;
import com.jmp17.todolist.exception.UnknownOperationException;

public class OperationFactory {
	
	private List<TodoItem> list;
	
	public void setList(List<TodoItem> list) {
		this.list = list;
	}

	public TodoListOperation getOperation(String operation, String... args) throws UnknownOperationException, InvalidArgumentsException {
		switch (operation) {
		case "add":
			String arg = args[0];
			return new AddItem(list, new TodoItem(arg));
		case "show":
			return new ShowItems(list);
		case "remove":
			try {
				int index = Integer.parseInt(args[0]);
				if (index < 1 || index > list.size()) {
					throw new InvalidArgumentsException(operation, "valid index is required");
				}
				return new RemoveItem(list, index-1);
				
			} catch (NumberFormatException  e) {
				throw new InvalidArgumentsException(operation, "valid integer is required");
			}
		case "clear":
			return new RemoveAll(list);
		default:
			throw new UnknownOperationException(operation);
		}
	}
}

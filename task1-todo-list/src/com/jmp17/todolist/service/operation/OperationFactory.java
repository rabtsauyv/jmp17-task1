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

	public TodoListOperation getOperation(Operation operation, String... args) throws UnknownOperationException, InvalidArgumentsException {
		switch (operation) {
		case ADD:
			String arg = args[0];
			return new AddItem(list, new TodoItem(arg));
		case SHOW:
			return new ShowItems(list);
		case REMOVE:
			try {
				int index = Integer.parseInt(args[0]);
				if (index < 1 || index > list.size()) {
					throw new InvalidArgumentsException(operation.getKey(), "valid index is required");
				}
				return new RemoveItem(list, index-1);
				
			} catch (NumberFormatException  e) {
				throw new InvalidArgumentsException(operation.getKey(), "valid integer is required");
			}
		case CLEAR:
			return new RemoveAll(list);
		default:
			throw new UnknownOperationException(operation.getKey());
		}
	}
}

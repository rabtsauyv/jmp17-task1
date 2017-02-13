package com.jmp17.todolist.service.operation;

import java.util.List;

import com.jmp17.todolist.entity.TodoItem;

public class RemoveItem implements TodoListOperation {

	private final List<TodoItem> list;
	private final int index;
	
	public RemoveItem(List<TodoItem> list, int index) {
		this.list = list;
		this.index = index;
	}

	@Override
	public String execute() {
		TodoItem item = list.remove(index);
		return "task removed: " + item.getTitle();
	}
}

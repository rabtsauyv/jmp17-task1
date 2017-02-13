package com.jmp17.todolist.service.operation;

import java.util.List;

import com.jmp17.todolist.entity.TodoItem;

public class AddItem implements TodoListOperation {

	private final List<TodoItem> list;
	private final TodoItem item;
	
	public AddItem(List<TodoItem> list, TodoItem item) {
		this.list = list;
		this.item = item;
	}
	
	@Override
	public String execute() {
		list.add(item);
		return "task added: " + item.getTitle();
	}

}

package com.jmp17.todolist.service.operation;

import java.util.List;

import com.jmp17.todolist.entity.TodoItem;

public class RemoveAll implements TodoListOperation {

	private final List<TodoItem> list;
	
	public RemoveAll(List<TodoItem> list) {
		this.list = list;
	}
	
	@Override
	public String execute() {
		list.clear();
		return "all tasks removed";
	}

}

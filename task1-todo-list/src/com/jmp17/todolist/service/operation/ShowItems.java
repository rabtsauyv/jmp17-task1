package com.jmp17.todolist.service.operation;

import java.util.List;

import com.jmp17.todolist.entity.TodoItem;

public class ShowItems implements TodoListOperation {

	private final List<TodoItem> list;
	
	public ShowItems(List<TodoItem> list) {
		this.list = list;
	}
	
	@Override
	public String execute() {
		StringBuilder output = new StringBuilder();
		int index = 1;
		for (TodoItem item : list) {
			output.append(index).append(". ").append(item.getTitle()).append("\n");
			index++;
		}
		if (output.length() < 1) {
			output.append("no tasks in the list");
		}
		return output.toString();
	}

}

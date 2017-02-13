package com.jmp17.todolist.persistence;

import java.util.List;

import com.jmp17.todolist.entity.TodoItem;

public interface TodoListDao {
	
	List<TodoItem> load();
	
	void persist(List<TodoItem> list);
}

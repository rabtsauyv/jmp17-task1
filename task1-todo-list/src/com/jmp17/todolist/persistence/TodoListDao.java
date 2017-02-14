package com.jmp17.todolist.persistence;

import java.util.List;

import com.jmp17.todolist.entity.TodoItem;
import com.jmp17.todolist.exception.DaoException;

public interface TodoListDao {
	
	List<TodoItem> load() throws DaoException;
	
	void persist(List<TodoItem> list) throws DaoException;
}

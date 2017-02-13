package com.jmp17.todolist.service;

import com.jmp17.todolist.exception.TodoListException;

public interface TodoListManager {
	String executeTask(String operation, String... args) throws TodoListException;
}

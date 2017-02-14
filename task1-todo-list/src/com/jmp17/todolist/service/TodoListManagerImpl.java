package com.jmp17.todolist.service;

import java.util.ArrayList;
import java.util.List;

import com.jmp17.todolist.entity.TodoItem;
import com.jmp17.todolist.exception.DaoException;
import com.jmp17.todolist.exception.TodoListException;
import com.jmp17.todolist.persistence.TodoListDao;
import com.jmp17.todolist.service.operation.Operation;
import com.jmp17.todolist.service.operation.OperationFactory;
import com.jmp17.todolist.service.operation.TodoListOperation;

public class TodoListManagerImpl implements TodoListManager {

	private List<TodoItem> list;
	private OperationFactory factory;
	private TodoListDao dao;
	
	public void setDao(TodoListDao dao) {
		this.dao = dao;
	}
	
	public void init() throws DaoException {
		list = new ArrayList<>();
				
		list.addAll(dao.load());
				
		factory = new OperationFactory();
		factory.setList(list);
	}
	
	public void shutdown() throws DaoException {
		dao.persist(list);
	}
	
	@Override
	public String executeTask(String operationKey, String... args) throws TodoListException {
		
		Operation operation = Operation.fromString(operationKey.trim());
		TodoListOperation operationObject = factory.getOperation(operation, args);
		
		return operationObject.execute();
	}

}

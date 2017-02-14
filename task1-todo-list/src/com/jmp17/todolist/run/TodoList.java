package com.jmp17.todolist.run;

import com.jmp17.todolist.controller.ConsoleController;
import com.jmp17.todolist.exception.DaoException;
import com.jmp17.todolist.persistence.TextFileTodoListDaoImpl;
import com.jmp17.todolist.service.TodoListManagerImpl;

public class TodoList {

	public static void main(String[] args) {
		try {
			ConsoleController controller = new ConsoleController();
			TodoListManagerImpl manager = new TodoListManagerImpl();
			TextFileTodoListDaoImpl dao = new TextFileTodoListDaoImpl("persistedTasks.txt");

			manager.setDao(dao);
			manager.init();
			controller.setManager(manager);
			controller.run();

			manager.shutdown();
		} catch (DaoException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

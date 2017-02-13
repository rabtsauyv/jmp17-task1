package com.jmp17.todolist.controller;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import com.jmp17.todolist.exception.TodoListException;
import com.jmp17.todolist.service.TodoListManager;

public class ConsoleController {
	
	private static final String INPUT_MSG = ">";

	private TodoListManager manager;
	private InputStream in = System.in;
	private PrintStream out = System.out;
	
	public void setManager(TodoListManager manager) {
		this.manager = manager;
	}
	
	public void run() {
		boolean exit = false;
		try (Scanner scan = new Scanner(in)) {
			while (!exit) {
				out.print(INPUT_MSG);
				String operation = scan.next();
				if (operation.trim().toLowerCase().equals("exit")) {
					exit = true;
					continue;
				}

				String otherContent = scan.nextLine();
				String msg;
				try {
					msg = manager.executeTask(operation, otherContent.trim());
				} catch (TodoListException e) {
					msg = e.getMessage();
				}
				out.println(msg);
			}
		}
	}
	
}

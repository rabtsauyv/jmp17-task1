package com.jmp17.todolist.exception;

import java.io.IOException;

public class DaoException extends IOException {

	public DaoException(String msg) {
		super(msg);
	}
	
	public DaoException(String msg, Throwable t) {
		super(msg, t);
	}
}

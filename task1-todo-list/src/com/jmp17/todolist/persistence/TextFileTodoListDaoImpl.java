package com.jmp17.todolist.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.jmp17.todolist.entity.TodoItem;

public class TextFileTodoListDaoImpl implements TodoListDao {
	
	private File file;
	
	public TextFileTodoListDaoImpl(String filename) {
		file = new File(filename);
		try {
		if (!file.exists()) {
			file.createNewFile();
		}
		} catch (IOException e) {
			throw new RuntimeException("init failed: " + e.getMessage(), e);
		}
		if (file.isDirectory()) {
			throw new RuntimeException("init failed: text file should be specified");
		}
	}

	@Override
	public List<TodoItem> load() {
		List<TodoItem> loadedItems = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String str = br.readLine();
			while (str != null) {
				TodoItem item = stringToItem(str);
				loadedItems.add(item);
				str = br.readLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("tasks were not loaded: " + e.getMessage(), e);
		}
		return loadedItems;
	}

	@Override
	public void persist(List<TodoItem> list) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (TodoItem todoItem : list) {
				bw.write(itemToString(todoItem));
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			throw new RuntimeException("tasks were not saved: " + e.getMessage(), e);
		}
	}

	private String itemToString(TodoItem item) {
		return item.getTitle();
	}
	
	private TodoItem stringToItem(String string) {
		TodoItem item = new TodoItem(string);
		return item;
	}
}
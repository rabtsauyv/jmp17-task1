package com.jmp17.task2.heap;

import com.jmp17.task2.run.RunTask2;

public class MemoryConsumer {
	private MemoryConsumer[] inner = new MemoryConsumer[10000];
	private String[] data;
	private int depth;
	
	public MemoryConsumer() {
		depth=0;
	}
	
	public MemoryConsumer(int depth) {
		this.depth=depth;
	}
	
	public void init() {
		if (depth < 10) {
			data = new String[1000000];
			for (int i = 0; i < data.length; i++) {
				String temp = new String("123abc");
				for (int j = 0; j < 10000; j++) {
					temp += new String("123abc");
				}
				data[i] = temp;
			}

			for (int i = 0; i < inner.length; i++) {
				inner[i] = new MemoryConsumer(depth + 1);
			}
			for (int i = 0; i < inner.length; i++) {
				inner[i].init();
				RunTask2.wrappedSleep(1000);
			}
		}
	}
}

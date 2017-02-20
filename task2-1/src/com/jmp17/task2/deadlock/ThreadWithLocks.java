package com.jmp17.task2.deadlock;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.jmp17.task2.run.RunTask2;

public class ThreadWithLocks extends Thread {
	
	private List<SharedResource> resources;
	
	public ThreadWithLocks(String name, SharedResource...resources) {
		super(name);
		this.resources = Arrays.asList(resources);
	}
	
	public void run() {
		if (resources != null) {
			takeResources(resources.iterator());
		}
	}
	
	private void takeResources(Iterator<SharedResource> resIterator) {
		if (resIterator.hasNext()) {
			SharedResource res = resIterator.next();
			System.out.println(getName() + " is locking " + res);
			synchronized (res) {
				System.out.println(getName() + " locked " + res);
				RunTask2.wrappedSleep(10000);
				takeResources(resIterator);
				System.out.println(getName() + " is releasing " + res);
			}
		}
//		Thread.getAllStackTraces().get(this)[0].
	}
}

package com.jmp17.task2.run;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.jmp17.task2.deadlock.SharedResource;
import com.jmp17.task2.deadlock.ThreadWithLocks;
import com.jmp17.task2.heap.MemoryConsumer;
import com.jmp17.task2.jmx.DataStorage;
import com.jmp17.task2.jmx.DataStorageMBean;

public class RunTask2 {

	public static void wrappedSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) { }
	}
	
	public static void main(String[] args) {
		initJmx();
		wrappedSleep(1000000);
		// TODO Auto-generated method stub
//		new RunTask2().script4();
//		new MemoryConsumer().init();
	}

	
	private void script1() {
		SharedResource res1 = new SharedResource("resource-1");
		SharedResource res2 = new SharedResource("resource-2");
		SharedResource res3 = new SharedResource("resource-3");
		SharedResource res4 = new SharedResource("resource-4");
		
		ThreadWithLocks t1 = new ThreadWithLocks("thread-1", res1, res2);
		ThreadWithLocks t2 = new ThreadWithLocks("thread-2", res2, res3);
		ThreadWithLocks t3 = new ThreadWithLocks("thread-3", res3, res4);
		ThreadWithLocks t4 = new ThreadWithLocks("thread-4", res4, res1);
		
		for (ThreadWithLocks t : Arrays.asList(t1,t2,t3,t4)) {
			t.start();
			wrappedSleep(100);
		}
	}
	
	private void script2() {
		SharedResource res1 = new SharedResource("resource-1");
		SharedResource res2 = new SharedResource("resource-2");
		
		ThreadWithLocks t1 = new ThreadWithLocks("thread-1", res1, res2);
		ThreadWithLocks t2 = new ThreadWithLocks("thread-2", res2, res1);
		
		for (ThreadWithLocks t : Arrays.asList(t1,t2)) {
			t.start();
			wrappedSleep(100);
		}
	}
	
	private void script3() {
		SharedResource res1 = new SharedResource("resource-1");
		
		ThreadWithLocks t1 = new ThreadWithLocks("thread-1", res1);
		ThreadWithLocks t2 = new ThreadWithLocks("thread-2", res1);
		ThreadWithLocks t3 = new ThreadWithLocks("thread-3", res1);
		ThreadWithLocks t4 = new ThreadWithLocks("thread-4", res1);
		ThreadWithLocks t5 = new ThreadWithLocks("thread-5", res1);
		
		for (ThreadWithLocks t : Arrays.asList(t1,t2,t3,t4,t5)) {
			t.start();
			wrappedSleep(100);
		}
//		printThread(t1);
	}
	
	private void script4() {
		SharedResource res1 = new SharedResource("resource-1");
		SharedResource res2 = new SharedResource("resource-2");
		SharedResource res3 = new SharedResource("resource-3");
		
		ThreadWithLocks t1 = new ThreadWithLocks("thread-1", res1, res2);
		ThreadWithLocks t2 = new ThreadWithLocks("thread-2", res2, res3);
		ThreadWithLocks t3 = new ThreadWithLocks("thread-3", res3, res1);
		
		for (ThreadWithLocks t : Arrays.asList(t1,t2,t3)) {
			t.start();
			wrappedSleep(100);
		}
	}
	
	public void printThread(Thread t) {
		StackTraceElement[] stack = t.getStackTrace();
		for (StackTraceElement element : stack) {
			System.out.println(element);
		}
		System.out.println(t.getState());
	}
	
	private static void initJmx() {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		DataStorageMBean mBean = new DataStorage();
		mBean.add("test-1");
		mBean.add("123");
		mBean.add("zxy__666777888_%$#");
		mBean.add("qwerty");
		
		try {
			ObjectName name = new ObjectName("com.task2.jmx:type=DataStorage");
			server.registerMBean(mBean, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

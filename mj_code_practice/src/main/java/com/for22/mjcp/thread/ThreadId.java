package com.for22.mjcp.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {
	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);

	// Thread local variable containing each thread's ID
	private static final ThreadLocal<String> threadId = new ThreadLocal<String>()/* {
		@Override
		protected Integer initialValue() {
			return nextId.getAndIncrement();
		}
	}*/;

	// Returns the current thread's unique ID, assigning it if necessary
	public String get() {
		String name = Thread.currentThread().getName();
		if(null == threadId.get()){
			System.out.println(name +",threadId.get() == null");
			set();
			threadId.set(""+nextId.get());
		}
		return name+"-"+threadId.get();
	}
	
	public void set(){
		nextId.compareAndSet(nextId.get(), nextId.getAndDecrement());
	}

}

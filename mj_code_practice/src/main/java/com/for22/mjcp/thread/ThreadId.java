package com.for22.mjcp.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {
	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);

	private static Var var =  new Var();
	{
		var.setValue("i am var init:"+var.toString());
	}
	// Thread local variable containing each thread's ID
	private static final ThreadLocal<Var> threadId = new ThreadLocal<Var>() /*{

		@Override
		protected Var initialValue() {
			System.out.println(var.getValue());
			return var;
		} 
	}*/;

	// Returns the current thread's unique ID, assigning it if necessary
	
	public String get() {
		String name = Thread.currentThread().getName();
		if(null == threadId.get()){
			//System.out.println(name +",threadId.get() == null");
			//set();
			//var.setValue(var.getValue()+"-"+nextId.get());
			threadId.set(var);
		}
		return this+"-"+name+"-"+threadId.get();
	}
	
	public void set(){
		nextId.compareAndSet(nextId.get(), nextId.getAndDecrement());
	}

}

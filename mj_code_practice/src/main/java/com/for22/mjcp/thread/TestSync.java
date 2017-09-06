/**
 * 
 */
package com.for22.mjcp.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程访问同步方法
 * @author liqiankun
 *
 */
public class TestSync {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SyncThread syncThread = new SyncThread();
		
		for(;;){
			new Thread(()->{
				syncThread.testInc();
			}).start();
		}
	}

}
class SyncThread{
	
	private final AtomicInteger atomicInteger = new AtomicInteger(0);
	

	public synchronized void testInc(){
		System.err.println(Thread.currentThread().getName()+':'+atomicInteger.getAndIncrement());
	} 
}
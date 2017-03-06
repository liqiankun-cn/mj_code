/**
 * 
 */
package com.for22.mjcp.concurrency.synchronousqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * The SynchronousQueue is a queue that can only contain a single element
 * internally. A thread inseting an element into the queue is blocked until
 * another thread takes that element from the queue. Likewise, if a thread tries
 * to take an element and no element is currently present, that thread is
 * blocked until a thread insert an element into the queue.
 * 
 * Calling this class a queue is a bit of an overstatement. It's more of a
 * rendesvouz point.
 * 
 * @author liqiankun
 *
 */
public class SynchronousQueueTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		SynchronousQueue<String> sq = new SynchronousQueue<String>(true);
		new Thread(){
			@Override
			public void run() {
				super.setName("SynchronousQueuePutThread");
				try {
					for(int i = 0;i<5;i++){
						System.out.println(Thread.currentThread().getName()+"-put "+i);
						sq.put("data:"+i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		new Thread(){

			@Override
			public void run() {
				super.setName("SynchronousQueueTakeThread");
				try {
					for(;;){
						String st = sq.take();
						System.out.println(Thread.currentThread().getName()+"-take "+st);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
		}.start();
	}
	
	
}


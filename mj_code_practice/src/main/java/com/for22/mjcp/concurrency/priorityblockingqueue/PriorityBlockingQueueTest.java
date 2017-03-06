/**
 * 
 */
package com.for22.mjcp.concurrency.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * The PriorityBlockingQueue is an unbounded concurrent queue. It uses the same
 * ordering rules as the java.util.PriorityQueue class. You cannot insert null
 * into this queue.
 * 
 * All elements inserted into the PriorityBlockingQueue must implement the
 * java.lang.Comparable interface. The elements thus order themselves according
 * to whatever priority you decide in your Comparable implementation.
 * 
 * Notice that the PriorityBlockingQueue does not enforce any specific behaviour
 * for elements that have equal priority (compare() == 0).
 * 
 * Also notice, that in case you obtain an Iterator from a
 * PriorityBlockingQueue, the Iterator does not guarantee to iterate the
 * elements in priority order.
 * 
 * @author liqiankun
 *
 */
public class PriorityBlockingQueueTest {

	static void testPriorityBlockingQueue(){
		PriorityBlockingQueue<String> pbq = new PriorityBlockingQueue<String>();
		//pbq.forEach(action);
		
		for(int i=0;i<10;i++)
			pbq.add(String.valueOf(i));
		
		
		while(!pbq.isEmpty()){
			String st = pbq.poll();
			System.out.println("poll "+st);
		}
		
		
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testPriorityBlockingQueue();
		
	}

}

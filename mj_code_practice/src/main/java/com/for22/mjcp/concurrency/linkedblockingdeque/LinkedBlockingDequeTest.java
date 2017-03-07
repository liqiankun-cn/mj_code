/**
 * 
 */
package com.for22.mjcp.concurrency.linkedblockingdeque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liqiankun
 *
 */
public class LinkedBlockingDequeTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		BlockingDeque<String> deque = new LinkedBlockingDeque<String>();

		deque.addFirst("1");
		deque.addLast("2");

		String two = deque.takeLast();
		String one = deque.takeFirst();
		System.out.println(one +"-"+two);
		
	}

}

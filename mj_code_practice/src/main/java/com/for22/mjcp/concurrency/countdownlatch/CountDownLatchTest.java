/**
 */
package com.for22.mjcp.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * A java.util.concurrent.CountDownLatch is a concurrency construct that allows
 * one or more threads to wait for a given set of operations to complete.<br>
 * 
 * A CountDownLatch is initialized with a given count. This count is decremented
 * by calls to the countDown() method. Threads waiting for this count to reach
 * zero can call one of the await() methods. Calling await() blocks the thread
 * until the count reaches zero.
 * 
 * 
 * @author liqiankun
 *
 */
public class CountDownLatchTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(5);
		Waiter      waiter      = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);
		new Thread(waiter).start();
		
		for(int i =0;i<5 ;i++){
			new Thread(decrementer).start();
		}
		
	}

}

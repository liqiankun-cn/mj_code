/**
 * 
 */
package com.for22.mjcp.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author liqiankun
 *
 */
public class Decrementer implements Runnable {
	CountDownLatch latch = null;

	public Decrementer(CountDownLatch latch) {
		this.latch = latch;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			this.latch.countDown();
			System.out.println("countDown");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

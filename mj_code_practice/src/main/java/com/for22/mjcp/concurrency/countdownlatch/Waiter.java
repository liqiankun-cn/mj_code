/**
 * 
 */
package com.for22.mjcp.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author liqiankun
 *
 */
public class Waiter implements Runnable {

	CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
        	System.out.println("begin await");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter Released");
    }

}

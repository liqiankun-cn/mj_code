/**
 * 
 */
package com.for22.mjcp.concurrency.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * The java.util.concurrent.CyclicBarrier class is a synchronization mechanism
 * that can synchronize threads progressing through some algorithm. In other
 * words, it is a barrier that all threads must wait at, until all threads reach
 * it, before any of the threads can continue.
 * 
 * The threads wait for each other by calling the await() method on the
 * CyclicBarrier. Once N threads are waiting at the CyclicBarrier, all threads
 * are released and can continue running
 * 
 * @author liqiankun
 *
 */
public class CyclicBarrierTest {

	/**
	 * @param args
	 * @throws BrokenBarrierException
	 * @throws InterruptedException
	 * @throws TimeoutException 
	 */
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException, TimeoutException {
		// When you create a CyclicBarrier you specify how many threads are to
		// wait at it, before releasing them
		//CyclicBarrier barrier = new CyclicBarrier(2);

		// Here is how a thread waits at a CyclicBarrier:
		//barrier.await();

		// You can also specify a timeout for the waiting thread. When the
		// timeout has passed the thread is also released, even if not all N
		// threads are waiting at the CyclicBarrier. Here is how you specify a timeout:
		//barrier.await(10, TimeUnit.SECONDS);
		
		
		Runnable barrier1Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 1 executed ");
		    }
		};
		Runnable barrier2Action = new Runnable() {
		    public void run() {
		        System.out.println("BarrierAction 2 executed ");
		    }
		};

		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

		CyclicBarrierRunnable barrierRunnable1 =
		        new CyclicBarrierRunnable(barrier1, barrier2);

		CyclicBarrierRunnable barrierRunnable2 =
		        new CyclicBarrierRunnable(barrier1, barrier2);

		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();

	}

}

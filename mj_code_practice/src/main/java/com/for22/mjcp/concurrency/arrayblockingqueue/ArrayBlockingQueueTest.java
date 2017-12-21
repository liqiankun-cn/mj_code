/**
 * 
 */
package com.for22.mjcp.concurrency.arrayblockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue is a bounded, blocking queue that stores the elements
 * internally in an array. That it is bounded means that it cannot store
 * unlimited amounts of elements. There is an upper bound on the number of
 * elements it can store at the same time. You set the upper bound at
 * instantiation time, and after that it cannot be changed.
 * 
 * The ArrayBlockingQueue stores the elements internally in FIFO (First In,
 * First Out) order. The head of the queue is the element which has been in
 * queue the longest time, and the tail of the queue is the element which has
 * been in the queue the shortest time.
 * 
 * @author liqiankun
 *
 */
public class ArrayBlockingQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ArrayBlockingQueue<Integer> abq0 = new ArrayBlockingQueue<Integer>(1);
			abq0.put(1);
			abq0.put(2);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(10);
		Random r = new Random();
		new Thread() {

			@Override
			public void run() {
				super.setName("putToArrayBlockingQueueThread");
				for (;;)
					abq.offer(r.nextInt(20));
			}

		}.start();

		new Thread() {

			@Override
			public void run() {
				super.setName("takeFromArrayBlockingQueueThread");
				while (true) {
					try {
						Integer it = abq.take();
						System.out.println("get " + it);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}.start();

	}

}

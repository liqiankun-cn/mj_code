/**
 * 
 */
package com.for22.mjcp.concurrency.linkedblockingqueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The LinkedBlockingQueue keeps the elements internally in a linked structure
 * (linked nodes). This linked structure can optionally have an upper bound if
 * desired. If no upper bound is specified, Integer.MAX_VALUE is used as the
 * upper bound.
 * 
 * The LinkedBlockingQueue stores the elements internally in FIFO (First In,
 * First Out) order. The head of the queue is the element which has been in
 * queue the longest time, and the tail of the queue is the element which has
 * been in the queue the shortest time.
 * 
 * @author liqiankun
 *
 */
public class LinkedBlockingQueueTest {

	static void testLinkedBlockingQueue() {
		ExecutorService es = Executors.newFixedThreadPool(2);

		final LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>();

		Random r = new Random();
		es.execute(new Runnable() {

			@Override
			public void run() {
				for (;;){
					String st = String.valueOf(r.nextInt(100));
					System.out.println("offer "+st);
					lbq.offer(st);
				}
			}
		});
		es.execute(new Runnable() {

			@Override
			public void run() {
				try {
					for (;;) {
						String st = lbq.take();
						System.out.println("take "+st);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

	}

	public static void main(String[] args) {
		testLinkedBlockingQueue();
	}

}

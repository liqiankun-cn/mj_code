/**
 * 
 */
package com.for22.mjcp.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liqiankun
 *
 */
public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(()->{
			System.out.println("---");
		});
	}

}

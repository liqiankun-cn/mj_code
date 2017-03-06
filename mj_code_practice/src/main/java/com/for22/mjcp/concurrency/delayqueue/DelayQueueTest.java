/**
 * 
 */
package com.for22.mjcp.concurrency.delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * The DelayQueue blocks the elements internally until a certain delay has expired. 
 * The elements must implement the interface java.util.concurrent.Delayed.
 * 
 * 测试DelayQueue，模拟一个缓存
 * @author liqiankun
 *
 */
public class DelayQueueTest {

	static void testCache(){


		try {
			Cache<Integer, String> cache = new Cache<Integer, String>();
			cache.put(1, "aaaa", 3, TimeUnit.SECONDS);

			Thread.sleep(1000 * 2);
			{
			    String str = cache.get(1);
			    System.out.println(str);
			}

			Thread.sleep(1000 * 2);
			{
			    String str = cache.get(1);
			    System.out.println(str);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
	
	}
	
	static void testQueue() throws InterruptedException{
		DelayQueue<DelayedElement> queue = new DelayQueue<DelayedElement>();
		DelayedElement element = new DelayedElement();
		element.setUsedCount(2);
		
		DelayedElement element2 = new DelayedElement();
		element2.setUsedCount(4);
		new Thread(){
			
			@Override
			public void run() {
				try {
					for(;;){
						
						DelayedElement de =	queue.take();
						System.out.println(de.getUsedCount());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread(){

			@Override
			public void run() {
				queue.add(element);
				queue.add(element2);
			}
			
		}.start();
		
		
		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//testCache();
		testQueue();
		
		
		
	}
	
	 

}

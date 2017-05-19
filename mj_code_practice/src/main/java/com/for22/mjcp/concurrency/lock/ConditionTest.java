package com.for22.mjcp.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * -+@author liqiankun
 *
 */
public class ConditionTest {

	public static void main(String[] args) {

		final ReentrantLock lock = new ReentrantLock();
		final Condition condition = lock.newCondition();
		for(int i = 0; i<5; i++){
			Thread wt1 = new Thread((Runnable)() -> {
				try {
					String name = Thread.currentThread().getName();
					lock.lock();
					System.out.println("我加锁了,"+name);
					
					System.out.println("我要等一个新信号,"+Thread.currentThread().getName());
					condition.await();
					System.out.println("拿到了一个信号,"+Thread.currentThread().getName());
					
					lock.unlock();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			},"waitThread"+i);
			wt1.start();
		}
		
		
		Thread wt2 = new Thread((Runnable)() -> {
			
			try {
				lock.lock();
				System.out.println("我拿到了锁,"+Thread.currentThread().getName());
				Thread.sleep(3000);
				condition.signalAll();
				System.out.println("我发了信号,"+Thread.currentThread().getName());
				lock.unlock();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		},"singalThread");
		wt2.start();
		
		
	}

}

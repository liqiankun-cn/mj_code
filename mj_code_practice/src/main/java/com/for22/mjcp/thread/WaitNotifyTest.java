/**
 * 
 */
package com.for22.mjcp.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mj
 *
 */
public class WaitNotifyTest {
	/**
	 * 线程锁
	 */
	private final Object object = new Object();

	private final ArrayBlockingQueue<Integer> list = new ArrayBlockingQueue<>(5);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WaitNotifyTest wn = new WaitNotifyTest();
		wn.startThread();
		wn.notifyThread();
	}

	/**
	 * 启动线程
	 */
	public void startThread() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {

				synchronized (object) {
					while (list.size() != 5) {
						try {
							System.out.println("进入等待状态。。。");
							object.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				System.out.println("线程结束。。。");
			}
		});
		t.start();
	}

	public void notifyThread() {
		synchronized (object) {
			for(int i =0;i<5;i++){
				list.offer(i);
				System.out.println("offer "+i);
			}
			object.notify();
			System.out.println("唤醒线程。。。");
		}

	}
}

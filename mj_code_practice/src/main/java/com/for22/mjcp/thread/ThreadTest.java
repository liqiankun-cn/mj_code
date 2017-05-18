/**
 * 
 */
package com.for22.mjcp.thread;

/**
 * @author liqiankun
 *
 */
public class ThreadTest {

	
	
	public static void main(String[] args) {
		Object obj = new Object();
		Thread t = new Thread(){

			@Override
			public void run() {
				System.out.println("22222222222");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				/*try {
					Thread.currentThread().wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
			
		};
		try {
			t.wait(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		t.notify();
		
		System.out.println(Thread.State.NEW.ordinal());
		System.out.println(Thread.State.RUNNABLE.ordinal());
	}
}

/**
 * 
 */
package com.for22.mjcp.thread;

/**
 * 测试object
 * 
 * @author liqiankun
 *
 */
public class TestJoin {

	
	
	static void testJoin(){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("First task started");
				System.out.println("Sleeping for 2 seconds");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("First task completed");
			}
		});
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Second task completed");
			}
		});
		t.start(); // Line 15
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Line 16
		t1.start();
	}

}

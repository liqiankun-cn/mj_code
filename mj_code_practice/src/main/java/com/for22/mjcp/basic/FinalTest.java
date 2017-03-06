/**
 * 
 */
package com.for22.mjcp.basic;

/**
 * @see http://docs.oracle.com/javase/tutorial/java/javaOO/localclasses.html#accessing-members-of-an-enclosing-class
 * @author liqiankun
 *
 */
public class FinalTest {
	
	void testString(String str){
		String str2 = "1";
		new Thread(){
			@Override
			public void run() {
				System.out.println(str);
				System.out.println(str2);
			}}.start();
	}
	void test(int num){
		int num2 = 0;
		new Thread(){
			@Override
			public void run() {
				System.out.println(num);
				System.out.println(num2);
			}}.start();
	}
	
	void testA(A a1){
		final A a = null;
		new Thread(){
			@Override
			public void run() {
				System.out.println(a1);
				System.out.println(a);
			}}.start();
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		FinalTest ft = new FinalTest();
		ft.wait();
	}	

}
class A{
	
}

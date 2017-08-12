/**
 * 
 */
package com.for22.mjcp.basic;

/**
 * @author liqiankun
 *
 */
public class Child extends Parent{
	private int a=0;
	
	public void test(){
		System.out.println(super.a);
		System.out.println(this.a);
		this.a=5;
		System.out.println(this.a);
		System.out.println(super.a);
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		c.test();
	}
	
}

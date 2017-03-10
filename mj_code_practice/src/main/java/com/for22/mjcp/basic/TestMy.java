/**
 * 
 */
package com.for22.mjcp.basic;

import com.for22.mjcp.basic.Outter.Inner;

/**
 * @author liqiankun
 *
 */
public class TestMy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Outter o = new Outter();
		Outter.Inner inner = new  Outter.Inner();
		Inner inner2 = new Inner();
		System.out.println(inner.test("xx"));
		System.out.println(inner2.test("oo"));
		
	}

}

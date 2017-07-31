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

	static int num = 0; 
	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {

		Outter.Inner inner = new  Outter.Inner();
		Inner inner2 = new Inner();
		Outter o = new Outter();
		int num3 = 3;
		System.out.println(inner.test("xx"));
		if(inner2 != null)
			o =null;
		num = 2;
		System.out.println("test J!"+o.hashCode());
		System.out.println(inner2.test("oo"));
		
		System.out.println("test condition");
		
	}

}

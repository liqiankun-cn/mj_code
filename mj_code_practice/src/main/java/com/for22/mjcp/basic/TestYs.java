/**
 * 
 */
package com.for22.mjcp.basic;

import com.for22.mjcp.basic.Outter.Inner;

/**
 * @author liqiankun
 *
 */
public class TestYs {
	private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Outter o = new Outter();
		Outter.Inner inner = new  Outter.Inner();
		Inner inner2 = new Inner();
		System.out.println(inner.test("xx"));
		System.out.println(inner2.test("oo"));
		System.out.println(5&3);
		System.out.println(5&2);
		System.out.println(5&1);
		System.out.println(25&13);
		System.out.println("workerCountOf:"+workerCountOf(1<<32));
		
		System.out.println("num:"+((1<<32)));
		System.out.println("num:"+(Math.pow(2, 31)));
		System.out.println("num:"+((1<<31)-1));
		System.out.println("num:"+Integer.MAX_VALUE);
	}

}

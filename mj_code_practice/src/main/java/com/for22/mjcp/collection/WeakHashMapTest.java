/**
 * 
 */
package com.for22.mjcp.collection;

import java.util.WeakHashMap;

/**
 * @author liqiankun
 *
 */
public class WeakHashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WeakHashMap<String, String> whm = new WeakHashMap<>();
		whm.put("test", "1111");
		
		String test = whm.get("test");
		System.out.println(test);
		test = null;
		System.out.println(whm);
		
	}

}

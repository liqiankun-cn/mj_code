/**
 * 
 */
package com.for22.mjcp.concurrency.concurrentmap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author liqiankun
 *
 */
public class ConcurrentMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConcurrentMap<String,String> cmap = new ConcurrentHashMap<String,String>();
		new Thread(){

			@Override
			public void run() {
				for(int i=0;i<10;i++){
					String v = i+String.valueOf(i);
					cmap.put("i"+i, v);
					System.out.println("put "+v);
				}
			}
			
		}.start();
		
		new Thread(){
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					String v = i+String.valueOf(i);
					cmap.put("j"+i, v);
					System.out.println("put "+v);
				}
			}
			
		}.start();
		
		Set<Map.Entry<String,String>> cs = cmap.entrySet();
		
		for(Entry<String,String> en:cs){
			System.out.println("get "+en.getKey()+"-"+en.getValue());
		}
	}

}

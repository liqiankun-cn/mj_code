/**
 * 
 */
package com.for22.mjcp.thread;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author liqiankun
 *
 */
public class ThreadLocalTest {

	 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> ls = Lists.newArrayList();
		ThreadId id = new ThreadId();
		for(int i =0 ;i<5;i++){
			new Thread("thread"+i){
				@Override
				public void run() {
					ls.add(id.get());
				}
			}.start();
		}
		ls.forEach(lc -> System.out.println(lc));
		
	}

	 
}
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
		//当前主线程-main
		List<String> ls = Lists.newArrayList();
		ThreadId id = new ThreadId();
		for(int i =0 ;i<5;i++){
			//启动5个执行线程
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
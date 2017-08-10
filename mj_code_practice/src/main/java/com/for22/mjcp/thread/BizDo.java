/**
 * 
 */
package com.for22.mjcp.thread;

/**
 * @author liqiankun
 *
 */
public class BizDo {

	public void doSomeThing(String traceId){
		System.out.println("Thread:["+Thread.currentThread().getName()+"],TraceId:["+traceId+"]");
		System.out.println();
	}
}

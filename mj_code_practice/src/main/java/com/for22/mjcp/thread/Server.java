/**
 * 
 */
package com.for22.mjcp.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;


/**
 * @author liqiankun
 *
 */
public class Server {

	private static final ThreadLocal<String> traceId = new ThreadLocal<String>();
	
	
	
	private final ExecutorService service = Executors.newCachedThreadPool();
	void accept(String reqTraceId){
		/*service.execute(()->{
			//new BizDo().doSomeThing(getTraceId()+"-"+reqTraceId);
		});*/
		new BizDo().doSomeThing(getTraceId()+"-"+reqTraceId);
		
	}

	
	public String getTraceId(){
		String sid = traceId.get();
		if(StringUtils.isBlank(sid)){
			String s = Thread.currentThread().getName();
			traceId.set(s);
		}
		return traceId.get();
	}
}

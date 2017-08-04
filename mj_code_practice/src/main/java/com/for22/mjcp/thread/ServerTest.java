package com.for22.mjcp.thread;

import java.util.Random;

public class ServerTest {

	public static void main(String[] args) {
		Server server = new Server();
		//发送5个请求
		//启动5个执行线程
		for(int i =0 ;i<5;i++){
			new Thread("thread"+i){
				@Override
				public void run() {
					String reqTraceId = String.valueOf(new Random().nextInt(100));
					server.accept(reqTraceId);
				}
			}.start();
			
		}
	}

}

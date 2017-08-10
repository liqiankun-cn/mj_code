package com.for22.mjcp.thread;

import java.io.IOException;
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
		
		
		try {
			String command = "E:/test.bat";
			Process process = 
					Runtime.getRuntime().exec(command);
					System.getSecurityManager();
					System.out.println("---");
					process.waitFor();
//			System.out.println(process.getInputStream().read(new byte[1024]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

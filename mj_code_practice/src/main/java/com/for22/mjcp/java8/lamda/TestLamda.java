package com.for22.mjcp.java8.lamda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLamda {

	public static void main(String[] args) {

		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(() -> {
			while(true){
				System.out.println("this is lamda test");
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		});
		executorService.shutdown();
	}

}

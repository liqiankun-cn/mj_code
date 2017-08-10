package com.for22.mjcp.concurrency.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
	private static final Exchanger<String> exgr = new Exchanger<String>();
	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String A = "银行流水A";// A录入银行流水数据
					String s = exgr.exchange(A);
					System.out.println("A 交换数据得到 "+s);
				} catch (InterruptedException e) {
				}
			}
		});
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				try {
					String B = "银行流水B";// B录入银行流水数据
					String B1 = "银行流水B1";// B录入银行流水数据
					String A = exgr.exchange(B);
					String A1 = exgr.exchange(B1);
					System.out.println(A1);
					System.out.println("A和B数据是否一致：" + A.equals(B) + ",A录入的是：" + A + ",B录入是：" + B);
				} catch (InterruptedException e) {
				}
			}
		});

		threadPool.shutdown();

	}

}

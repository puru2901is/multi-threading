package com.baghel.multithreading.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadVsExecuotrServiceExample {
	
	public void processor() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void main() throws InterruptedException{
		System.out.println("starting.......");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(()->{
			processor();
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ExecutorService executorService = Executors.newFixedThreadPool(1);
//		executorService.submit(()->{
//			processor();
//		});
//		executorService.shutdown();
//		executorService.awaitTermination(1, TimeUnit.DAYS);
		long end = System.currentTimeMillis();
		System.out.println("Time taken: "+(end-start));
		
	}
}

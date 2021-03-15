package com.baghel.multithreading.synchronizedBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();
	private Random random = new Random();
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 =  new ArrayList<>();
	
	public void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}
	
	public void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}
		
	}
	
	public void process() {
		for(int i = 0 ; i< 1000;i++) {
			stageOne();
			stageTwo();
		}
	}
	public void main() throws InterruptedException {
		System.out.println("Starting.......");
		long start = System.currentTimeMillis();
//		ExecutorService executorService = Executors.newFixedThreadPool(5);
//		executorService.execute(()->process());// this way it is even taking more time then process() method
//		try {
//			executorService.shutdown();
//			executorService.awaitTermination(10, TimeUnit.HOURS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Thread t1 = new Thread(() -> process());
		Thread t2 = new Thread(() -> process());
		t2.start();
		t1.start();
		t1.join();
		t2.join();
		
		long end = System.currentTimeMillis();
		System.out.println("Time taken: "+(end-start));
		System.out.println("List1 size: "+list1.size()+" list2 size: "+ list2.size());
	}
	

}

package com.baghel.multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	
	CountDownLatch countDownLatch;
	
	public void main() {
		
		String[] items = {"Pizza", "Bread garlic","Paste"};
		countDownLatch =  new CountDownLatch(items.length);
		System.out.println("Item received......");
		Thread t1 = new Thread(()->{
			processPizza();
			countDownLatch.countDown();
		});
		Thread t2 = new Thread(()->{
			processGarlicBread();
			countDownLatch.countDown();
		});
		Thread t3 = new Thread(()->{
			processPasta();
			countDownLatch.countDown();
		});
		t1.start();
		t2.start();
		t3.start();
		try {
			System.out.println(countDownLatch.getCount());
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All orders prepared");
		
	}
	private void processPizza() {
		System.out.println("Pizza Process started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pizza Prepared");
	}
	private void processPasta() {
		System.out.println("Pasta Process started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pasta Prepared");
	}
	private void processGarlicBread() {
		System.out.println("Garlic Bread Process started");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Garlic Bread Prepared");
	}

}

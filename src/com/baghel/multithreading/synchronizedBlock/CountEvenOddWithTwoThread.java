package com.baghel.multithreading.synchronizedBlock;

public class CountEvenOddWithTwoThread {

	public void main() throws InterruptedException {
		Thread t1= new Thread(()->{
			for(int i =1 ;i < 100;i+=2) {
				System.out.println("odd :"+i);
			}
		});
		Thread t2= new Thread(()->{
			for(int i =0 ;i < 100;i+=2) {
				System.out.println("even :"+i);
			}
		});
		Thread t3= new Thread(()->{
			for(int i =0 ;i < 100;i++) {
				System.out.println("number :"+i);
			}
		});
		
		System.out.println("starting.......");
		long start = System.nanoTime();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		long end = System.nanoTime();
		System.out.println("Time taken: "+(end-start));
		
	}
}

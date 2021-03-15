package com.baghel.multithreading.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ImplementingRunnableInterface {
	
	int count = 0;
	private void loopOneToTen() {
		count++;
		for(int i =0 ; i< 10; i++) {
			
			System.out.println("hello "+i +" by thread "+Thread.currentThread().getName());
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ImplementingRunnableInterface im = new ImplementingRunnableInterface();
		Map<Integer,Integer> map = new HashMap<>();
		
		Thread t1 = new Thread(()-> im.loopOneToTen());
		Thread t2 = new Thread(()-> im.loopOneToTen());
		t1.start();
		t2.start();
		im.loopOneToTen();
		t1.join();
		t2.join();
		
		System.out.println(im.count);
		
		
		//thread data cache  and thread interleaving

	}

}

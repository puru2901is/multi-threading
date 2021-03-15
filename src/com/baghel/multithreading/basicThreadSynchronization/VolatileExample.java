package com.baghel.multithreading.basicThreadSynchronization;

class Processor extends Thread{
	private volatile boolean running = true; //use volatile not to cache in the thread.
	
	@Override
	public void run() {
		while(running) {
			System.out.println("Hello");
			
		}
	}
	
	public void shotdown() {
		System.out.println("in thread "+ Thread.currentThread().getState());
		running = false;
	}
}

/**
 * @author purushottambaghel
 *
 *volatile keyword is used for solving the visibility problem i.e. changes made by one thread to shared
 *obj are visible to other threads too.
 *
 * the value of volatile is never cached and always read from main memory.
 * 
 * other problem benefit of synchronized keyword is atomicity. Volatile doesn't provide that.
 *
 */
public class VolatileExample {
	
	public static void main(String[] args) throws InterruptedException {
		Processor p1 = new Processor();
		p1.start();
		Thread.sleep(100);
		p1.shotdown();
	}	
}

package com.baghel.multithreading.threadState;

public class ThreadStateExample {
	
	private static Thread t1;
	private static Thread t2;
	static String a = "hello";
	
	private static void threadMethod() {
		System.out.println("This is runnable State of "+ Thread.currentThread().getName()+" " +Thread.currentThread().getState());
		synchronized (a) {
			try {
				Thread.sleep(10000);
				a.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void threadMethod2() {
		synchronized (a) {
			System.out.println("This is waiting state for t1: "+t1.getState());
			a.notify();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		t1 = new Thread(()->threadMethod());   //new thread is created
		t2 = new Thread(()->threadMethod2());
		
		System.out.println("This is new State for t1: "+t1.getState());
		t1.start(); 						//this is runnable state
		Thread.sleep(10);
		t2.start();
		Thread.sleep(10);
		System.out.println("This is blocked State for t2: "+t2.getState());
		System.out.println("This is timed wait State for t1: "+t1.getState());
		t1.join();
		System.out.println("This is terminated State for t1:"+t1.getState());
		

	}

}

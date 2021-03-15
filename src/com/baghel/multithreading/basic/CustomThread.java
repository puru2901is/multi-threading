package com.baghel.multithreading.basic;

class Runner extends Thread{
	@Override
	public void run() {
		for(int i =0 ; i< 10; i++) {
			
			System.out.println("hello "+i +" by thread "+Thread.currentThread().getId());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class CustomThread {

	public static void main(String[] args) {
		Runner r =  new Runner();
//		If we call r.run() int will run in the start thread i.e. main thread. It won't start the new 
//		Thread
		r.start();
		Runner r1 =  new Runner();
		r1.start();
		try {
			r.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

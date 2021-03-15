package com.baghel.multithreading.synchronization;

/**
 * @author purushottambaghel
 * 
 * Synchronized keyword guarantee following things:
 * 
 * First, it is not possible for two invocations of synchronized methods on the same object to interleave.
 *  When one thread is executing a synchronized method for an object, all other threads that invoke 
 *  synchronized methods for the same object block (suspend execution) until the first thread 
 *  is done with the object.
 *  
 * Second, when a synchronized method exits, it automatically establishes a happens-before 
 *	relationship with any subsequent invocation of a synchronized method for the same object.
 * 	This guarantees that changes to the state of the object are visible to all threads.
 *
 */
public class SynchronizedExample {
	
	int count = 0;

	public static void main(String[] args) throws InterruptedException {
		
		SynchronizedExample synchronizedExample = new SynchronizedExample();
		synchronizedExample.todoTask();

	}
	
	private synchronized void increment() {
		count++;
	}
	
	private void incrementCount() {
		for(int i=0;i<100000;i++)
			increment();
	}
	
	public void todoTask() throws InterruptedException {
		Thread t1 = new Thread(()-> incrementCount());
		Thread t2 = new Thread(()-> incrementCount());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println(count);
		
	}

}

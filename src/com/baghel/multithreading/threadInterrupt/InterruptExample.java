package com.baghel.multithreading.threadInterrupt;

/**
 * @author purushottambaghel
 * 
 * NOTE: Based on the last run of this program I think Thread.currentThread.isInterrupted may have 
 * Visibility problem. That can be solved by volatile keyword.
 *
 *This method allow us to interrupt the thread in between the process.
 *
 *Interrupt is a cooperative mechanism for indicating stop signal to a thread.
 *
 *There is a internal flag known as the interrupt status.
 *Invoking Thread.interrupt sets this flag.
 *When a thread checks for an interrupt by invoking the static method Thread.interrupted, 
 *interrupt status is cleared. 
 *The non-static isInterrupted method,
 * which is used by one thread to query the interrupt status of another, 
 * does not change the interrupt status flag.
 *
 */
public class InterruptExample {
	
	private static void processData() {
		for(int i=0;i<1000;i++) {
			try {
				System.out.println("processing "+i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("this is interrupted at "+i);
				return;
			}
		}
	}
	
	private static void processData1(){
		int a[] = new int[1000000];
		for(int i=0;i<1000000;i++) {
			for(int j=0;j<1000000;j++) {
				a[j] = i;
			}
			//System.out.println("processing "+i);  
			/*
			 * need to understand why it is only working with sysout
			 * if(Thread.currentThread().isInterrupted()) {
			 */
			if(Thread.interrupted()) {
				//throw new InterruptedException();
				System.out.println("thread is interrupted "+i);
				return;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(()-> processData1());
		t1.start();
		Thread.sleep(3000);
		t1.interrupt();

	}

}

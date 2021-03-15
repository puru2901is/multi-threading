package com.baghel.multithreading.producerConsumerProblem;

public class Resource {
	
	private String message = "";
	private boolean empty = true;
	
	public void produce(String message){
		synchronized (this) {
			while(!empty) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("producer producing : "+message);
			this.message = message;
			this.empty = false;
			this.notifyAll();
		}
	}
	
	public String consume(){
		synchronized (this) {
			while(empty) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.empty = true;
			this.notifyAll();
			return this.message;
		}
		
	}

}

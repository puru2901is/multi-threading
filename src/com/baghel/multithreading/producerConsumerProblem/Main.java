package com.baghel.multithreading.producerConsumerProblem;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Main {
	
	public static void main(String[] args) {

		
		Resource resource =  new Resource();
		Random r =  new Random();
		Thread producer = new Thread(()->{
			String[] messages = {"hello", "hi","we are at work","working for consumer producer problem"};
			for(String s: messages) {
				resource.produce(s);
				try {
					Thread.sleep(r.nextInt(5000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			resource.produce("DONE");
		});
		
		Thread consumer = new Thread(()->{
			String s = resource.consume();
			while(!"DONE".equalsIgnoreCase(s)) {
				
				System.out.println("Consumer consumes: "+s);
				s = resource.consume();
			}	
			
		});
		
		producer.start();
		consumer.start();
				
		
	}


}

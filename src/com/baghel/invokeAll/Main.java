package com.baghel.invokeAll;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		Set<Callable<String>> callables = new HashSet<Callable<String>>();
		for(Integer i =0;i<10;i++) {
			final String j = i.toString();
			callables.add(()->{
				printCustom("s"+j);
				return "s"+j;
			});
		}
		
		try {
			executorService.invokeAll(callables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println();
		System.out.println("after invoke ALl");
	
		System.out.println("b isShutDown "+executorService.isShutdown());
		System.out.println("b sTerminated "+executorService.isTerminated());
		executorService.shutdown();
		System.out.println();
		System.out.println("isShutDown "+executorService.isShutdown());
		System.out.println("isTerminated "+executorService.isTerminated());
		try {
			System.out.println("is without timeout terminated "+executorService.awaitTermination(1, TimeUnit.MINUTES));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("isShutDown "+executorService.isShutdown());
		System.out.println("isTerminated "+executorService.isTerminated());

	}
	
	private static void printCustom(String s) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(s);
	}

}

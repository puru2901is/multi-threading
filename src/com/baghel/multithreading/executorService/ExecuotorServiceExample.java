package com.baghel.multithreading.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecuotorServiceExample {

	int a = 0, b=0,c =0, max= 10000000;
	
	
	public void incrementA(int n) {
		System.out.println("Task1 started");
		List<Integer> list = new ArrayList<Integer>();
		int i = 0, j = 0, flag = 0;
		for (i = 1; i <= n; i++) {
			if (i == 1 || i == 0)
				continue;

			flag = 1;

			for (j = 2; j <= i / 2; ++j) {
				if (i % j == 0) {
					flag = 0;
					break;
				}
			}

			if (flag == 1)
				list.add(i);
		}
		System.out.println("Task1 ended");
	}
	
	public void incrementB(int n) {
		System.out.println("Task2 started");
		List<Integer> list = new ArrayList<Integer>();
		 int i, j, flag;  
		    for (i = 1; i <= n; i++)  
		    {   
		        if (i == 1 || i == 0)  
		            continue;  
		  
		        flag = 1;  
		  
		        for (j = 2; j <= i / 2; ++j)  
		        {  
		            if (i % j == 0) 
		            {  
		                flag = 0;  
		                break;  
		            }  
		        }  
		  
		        if (flag == 1)  
		            list.add(i); 
		    } 
		System.out.println("Task2 ended");
	}
	
	public void incrementC(int n) {
		System.out.println("Task3 started");
		List<Integer> list = new ArrayList<Integer>();
		 int i, j, flag;  
		    for (i = 1; i <= n; i++)  
		    {   
		        if (i == 1 || i == 0)  
		            continue;  
		  
		        flag = 1;  
		  
		        for (j = 2; j <= i / 2; ++j)  
		        {  
		            if (i % j == 0) 
		            {  
		                flag = 0;  
		                break;  
		            }  
		        }  
		  
		        if (flag == 1)  
		            list.add(i); 
		    } 
		System.out.println("Task3 ended");
	}
	
	public void main() throws InterruptedException {
		System.out.println("starting.......");
		long start = System.currentTimeMillis();
		//mainThreadExecution();
		//threeThreadExecution();
		
		executorServiceExecution();
		long end = System.currentTimeMillis();
		System.out.println("Time taken: "+(end-start));
		
	}

	private void executorServiceExecution() throws InterruptedException {
		List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
		tasks.add(()->{
			incrementA(200000);
			return Boolean.TRUE;
		});
		tasks.add(()->{
			incrementB(200000);
			return Boolean.TRUE;
		});
		tasks.add(()->{
			incrementC(200000);
			return Boolean.TRUE;
		});
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.invokeAll(tasks);
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);
	}

	private void threeThreadExecution() throws InterruptedException {
		Thread t1 = new Thread(()->{
			incrementA(200000);
		}); 
		Thread t2 = new Thread(()->{
			incrementB(200000);
		});
		Thread t3 = new Thread(()->{
			incrementC(200000);
		});
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();t3.join();
	}

	private void mainThreadExecution() {
		incrementA(200000);
		incrementB(200000);
		incrementC(200000);
	}

}

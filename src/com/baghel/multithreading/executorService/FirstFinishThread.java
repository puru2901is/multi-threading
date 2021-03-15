package com.baghel.multithreading.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class FirstFinishThread {
	
	private static volatile AtomicBoolean flag = new AtomicBoolean(true);

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ExecutorService ex = Executors.newFixedThreadPool(3);
		List<Callable<Boolean>> tasks = new ArrayList<>();
		for(int i = 0;i< 3;i++) {
			tasks.add(()->{
				print(10);
				return Boolean.TRUE;
			});
		}
		List<Future<Boolean>> futures = ex.invokeAll(tasks);
		for(Future<Boolean> f: futures) {
			try {
				f.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("In Interrupted exception");
				System.out.println(e.getMessage());
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("In Execution mr,'j/   			m          exception");
				System.out.println(e.getMessage());
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("In exception");
				System.out.println(e.getMessage());
			}
		}
		ex.shutdown();

	}
	
	private static void print(int n) throws Exception {
		for(int i = 0;i<n;i++) {
			//System.out.println(Thread.currentThread().getName()+"...."+i);
		}
		Thread.sleep(100);
		if(flag.compareAndSet(true,false)) {
			//System.out.println(Thread.currentThread().getName()+"...WON");
			throw new Exception("this is exception");
		} else {
			System.out.println(Thread.currentThread().getName()+"...LOST");
		}
	}

}

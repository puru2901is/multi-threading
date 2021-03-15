package com.baghel.multithreading.bulkTry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BulkWithExecutor {
	
	private AtomicInteger total = new AtomicInteger(0);
	
	private void createBulk(List<Integer> list) {
		total.addAndGet(list.size());	
	}
	
	public void main() {
		ExecutorService executorService =  Executors.newFixedThreadPool(20);
		
		List<Callable<Boolean>> tasks =  new ArrayList<>();
		int i =0;
		
		while(i < 1000) {
			final List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,7,4,8);
			tasks.add(() -> {
				createBulk(list);
				return Boolean.TRUE;
			});
			i++;
		}
		try {
			executorService.invokeAll(tasks);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(total);
	}
}

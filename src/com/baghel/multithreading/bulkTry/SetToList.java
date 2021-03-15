package com.baghel.multithreading.bulkTry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SetToList {
	private Set<Integer> set = ConcurrentHashMap.newKeySet();
	
	public void addToSet() throws InterruptedException {
		ExecutorService executorService =  Executors.newFixedThreadPool(100);
		List<Callable<Boolean>> tasks = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			final int e = i;
			tasks.add(()->{
				set.add(e);
				return Boolean.TRUE;
			});		
		}
		executorService.invokeAll(tasks);
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.DAYS);
	}
	
	public void setList() {
		List<Integer> docs = new ArrayList<>();
		docs.addAll(set);
		System.out.println(set.size());
		System.out.println(docs.size());
	}
	
	public static void main(String[] args) {
		SetToList setToList =  new SetToList();
		try {
			setToList.addToSet();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setToList.setList();
	}
}

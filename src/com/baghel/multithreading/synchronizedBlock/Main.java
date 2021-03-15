package com.baghel.multithreading.synchronizedBlock;

public class Main {

	public static void main(String[] args) {
		try {
			//new Worker().main();
			new CountEvenOddWithTwoThread().main();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

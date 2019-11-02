package com.java.Threads;

public class ThreadExample implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread T = new Thread(new ThreadExample());
		T.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("i am pillesh thread");
	}

}

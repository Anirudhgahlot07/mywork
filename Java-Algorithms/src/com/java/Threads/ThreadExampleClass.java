package com.java.Threads;

public class ThreadExampleClass extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadExampleClass t = new ThreadExampleClass();
		//t.start();
		t.run();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("hum pillesh");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hum pillesh bad wala");
	}
	
	
	

}

package com.java.Array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public  class TestImpl {

	
	
	static
	{
		System.out.println("static first");
	}
	
	public static  void main(String...ab) throws IOException
	{

		//String a= new String("1");
	//	String b =new String("1");
		
		
		Integer a = new Integer(1);
		Integer b = new Integer(a);
		
	
		/*
		Integer a =1;
		Integer b =a;*/
		
		try {
			FileInputStream fis = new FileInputStream("abc.text");
			int read =fis.read();
			
			FileOutputStream fout = new FileOutputStream("abc.text");
			fout.write(12);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(a==b)
			System.out.println("true");
		else
			System.out.println(a.hashCode() +" "+b.hashCode() );
	}
	
	public  void main1(int...ab)
	{

		//String a= new String("1");
	//	String b =new String("1");
		
		Integer a = new Integer(1);
		Integer b = new Integer(a);
	
		
		/*Integer a =1;
		Integer b =a;
		*/
		if(a==b)
			System.out.println("true");
		else
			System.out.println(a.hashCode() +" "+b.hashCode() );
	}
	
	

	public  class  ab extends TestImpl
	{
		ab ob = new ab();
	
	}
}



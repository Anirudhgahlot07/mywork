package com.java.Array;

import java.util.Scanner;

public class ArrayDeletion  extends Exception
{
	public static void main(String arg)  
	{
		System.out.println("test overload main");
	}

	
	public static void main(String[] args)    {
		// TODO Auto-generated method stub
		
		System.out.println("Enter size of array");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayDeletion test =null; 
		try {
			int x = 10/0;
			System.out.println(x);
	         throw new ArrayDeletion() ;
	      }
	      catch(ArrayDeletion t) {
	         System.out.println("Got the Test Exception");
	      }
		catch(ArithmeticException t) {
	         System.out.println("Got / by 0");
	      }
	      finally {
	         System.out.println("Inside finally block ");
	      }
		
	
		
		
		//test.testFun();
		
		System.out.println("enter elements ");
		int arr[] = new int[n];
		
		for(int i =0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			
			
		}
		
		System.out.println("elements are :");
		for(int i =0;i<n;i++)
		{
			System.out.println(arr[i]);
			
			
		}
		System.out.println("enter item to delete");
		int item = sc.nextInt();
		System.out.println("after del");
		
		n = deleteArray(arr, item);
		for(int i =0;i<n;i++)
		{
			System.out.println(arr[i]);
			
			
		}
		
		sc.close();
	}
	
	static void deleteArray(int arr[])
	{
		
	}
	
	static int deleteArray(int arr[],int item)
	{
		int n = arr.length;
		int prev = arr[n-1];
		int curr;
		int i;
		for(i=n-2;i>=0 && arr[i]!=item;i--)
		{
			curr = arr[i];
			arr[i-1]=prev;
			prev=curr;
			
		}
		
		if(i<0)
			return 0;
		
		arr[i]=prev;
		
		return n-1;
	}
	

}

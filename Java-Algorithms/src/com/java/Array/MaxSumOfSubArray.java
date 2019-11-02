package com.java.Array;

import java.util.Scanner;

public class MaxSumOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.out.println("enter the size of array");
		
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr [] = new int[size];
		for(int i =0 ;i<size;i++)
		{
			arr[i]=sc.nextInt();
		}
		

		for(int i =0 ;i<size;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		
		
		System.out.println("sum is  :"+MaxSub(arr));
		
		
		
		sc.close();


	}
	
	
	static int MaxSub(int []arr)
	{
		int len = arr.length;
		int max=0,currmax=0,sum=arr[0];
		currmax =arr[0];
		if(len==1)
			return arr[0];
		for(int i =1;i<len;i++)
		{
			sum+=arr[i];
			if(sum<arr[i])
			{
				sum=arr[i];
				max=Math.max(sum,currmax);
			}
			else
				max=Math.max(sum,currmax);
			currmax=max;
		}
		
		return max;
	}

}

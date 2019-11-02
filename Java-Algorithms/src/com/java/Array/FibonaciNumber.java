package com.java.Array;

import java.util.Scanner;

public class FibonaciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("enter number");
		Scanner sc = new  Scanner(System.in);
		int  num =sc.nextInt();
		
		System.out.println("num is :"+findfibonaci(num));
		sc.close();
	}
	
	
	
	static int findfibonaci(int n)
	{
		int dp[] = new int[n+2];
		dp[0]=0;
		dp[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}
	
	
	
}

package com.java.JavaProblems;

public class Problem1 {

	public static void main(String[] args) {
		
		int arr[]= {10,20,30,40,50,60,70,80,90};
		System.out.println(tellNoWays(arr, arr.length, 100));
	}
	
	
	public static int tellNoWays(int arr[],int sizeOfArray,int number)
	{
		int countArray[][] = new int[sizeOfArray+1][number+1];
		
		for(int i=0;i<=sizeOfArray;i++)
		{
			countArray[i][0]=1;
			
		}
		
		for(int i=0;i<=number;i++)
		{
			countArray[0][i]=0;
			
		}
		
		for(int i=1;i<=sizeOfArray;i++)
		{
			for(int j=1;j<=number;j++)
			{
				if(arr[i-1]<=j)
				{
					countArray[i][j]=countArray[i-1][j]+countArray[i][j-arr[i-1]];
				}
				else
					countArray[i][j] = countArray[i-1][j];
				
			}
		}
		return countArray[sizeOfArray][number];
	}

}

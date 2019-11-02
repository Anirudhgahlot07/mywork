package com.java.Array;

import java.util.Scanner;

public class Merge2MandNsizeArray {

	public static void main(String[] args) {
		
		System.out.println("Enter the size of the array");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr1[] = new int[n];
		
		for(int i =0;i<n;i++)
		{
			arr1[i]=sc.nextInt();
		}
		
		for(int i =0;i<arr1.length;i++)
		{
			System.out.print(arr1[i]+"\t");
		}
		
		int m = sc.nextInt();
		int Merged[] = new int[m];
		
		for(int i =0;i<m;i++)
		{
			Merged[i]=sc.nextInt();
		}
		System.out.println("\n");
		Merged =	mergeMplusNsizeArray(arr1, Merged);
		

		for(int i =0;i<m;i++)
		{
			System.out.print(Merged[i]+"\t");
		}
		
		sc.close();

	}

public static int[] mergeMplusNsizeArray(int arr[],int []merge)
	
	{
		int m=merge.length;
		int n = arr.length;
		
		
		shiftBlankSpace(merge);
		
		int k=0; int shift=n;
		
		for(int i=0;i<m;i++)
		{
			
			if(k<n)
			{
			
			if(shift<m && k<n&&merge[shift]>arr[k])
			{
				//int temp=merge[i];
				merge[i]=arr[k];			
				k++;
				
			}
			else if(shift<m)
			{
				
				merge[i]=merge[shift];
				shift++;
				
				
			}
			else
			{
				merge[i]=arr[k];
				k++;
			}
			}
			
		}
		
		return merge;
	}

		public static void shiftBlankSpace(int arr[])
		{
			int n = arr.length;
			
			int j=n-1;
			
			for(int i=n-1;i>=0;i--)
			{
				if(arr[i]!=-1)
				{
					arr[j]=arr[i]	;
					j--;
				}
				
			}
		}
}


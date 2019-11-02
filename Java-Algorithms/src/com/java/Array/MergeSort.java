package com.java.Array;

import java.util.Scanner;

public class MergeSort {

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
		
		Sort(arr, 0, size-1	);
		System.out.println("sorted array :");
		for(int i =0 ;i<size;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		
		
		
		sc.close();


	}
	
	static void Sort(int arr[],int low,int high)
	{
		int mid=0;
		if(low<high)
		{
			 mid=(low+high)/2;
		
		
		Sort(arr,low,mid);
		Sort(arr,mid+1,high);
		Merge(arr,low,mid,high);
		}
	}

	static void Merge(int []arr,int low,int mid,int high)
	{
		int lsize = mid-low+1;
		int rsize = high-mid;
		int left[]=new int[lsize];
		int right[]  = new int[rsize];
		 
		
		int l=0,r=0,k=low;
		
		for(int i=0;i<lsize;++i)
		{
			left[i]=arr[low+i];
		}
		
		for(int i=0;i<rsize;++i)
		{
			right[i]=arr[mid+i+1];
		}
		
		for(;l<lsize &&r<rsize;)
		{
			
			if(left[l]<=right[r])
			{
				arr[k]=left[l];
					l++;
			}
			else
			{
				arr[k]=right[r];
						r++;
			}
			k++;
						
		}			
		
		while(l<(lsize))
		{
			arr[k]=left[l];
			k++;
			l++;
			
		}
		while(r<(rsize))
		{
			arr[k]=right[r];
			k++;
			r++;
		}
			
		
	}
}

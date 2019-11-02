package com.java.Array;

import java.util.Scanner;

public class HeapSort {

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
		
		sort(arr);
		System.out.println("sorted array :");
		for(int i =0 ;i<size;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		
		
		
		sc.close();

		

	}
		
	static void buildHeap(int arr[],int n,int k)
	{
		
		
		int left ,right,parent;
		parent =k;
		left=k*2+1;
		right=k*2+2;
		
		if(left<n && arr[parent]<arr[left])
		{
			parent=left;
			
		}
			
		if(right<n &&  arr[parent]<arr[right])
		{
				parent=right;
		}	
		
		if(k!=parent)
		{
			int temp = arr[k];
			arr[k]=arr[parent];
			arr[parent]=temp;
			buildHeap(arr, n, parent);
		}
		
		
		
	
	}
	
	static void sort(int arr[])
	{
		int n =arr.length;
		
		for(int i =n/2-1;i>=0;i--)
			buildHeap(arr, n, i);
		
		for(int i =n-1;i>=0;i--)
		{
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			
			buildHeap(arr, i, 0);
		}
		
	}

}

package com.java.Array;

import java.util.Scanner;

public class Merge2SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		n = sc.nextInt();
		int arr2[] = new int[n];
		
		
		for(int i =0;i<n;i++)
		{
			arr2[i]=sc.nextInt();
		}
		
		for(int i =0;i<arr2.length;i++)
		{
			System.out.print(arr2[i]+"\t");
		}
		System.out.println("\n");
		
		int Merged[] = new int[arr1.length+n];
		
		Merged =Merge2array(arr1,arr2,Merged);
		
		for(int i =0;i<Merged.length;i++)
		{
			System.out.print(Merged[i]+"\t");
		}
		
		
		sc.close();
		
	}
	
	public static int[] Merge2array(int arr1[],int []arr2,int []Merged)
	{
		int n1 = arr1.length;
		int n2 = arr2.length;
		int n3 = Merged.length;
		
		int k=0,l=0,i=0;
		for( i=0;i<n3;i++)
		{
			if(k<n1 && l<n2&& arr1[k]<=arr2[l] )
			{
				Merged[i]=arr1[k];
				k++;
			}
			else if( l<n2)
			{
				Merged[i]=arr2[l];
				l++;
			}
			else
				break;
				
		}
		
		while(k <n1)
		{
			Merged[i]=arr1[k];
			i++;
			k++;
		}
		while(l <n2)
		{
			Merged[i]=arr2[l];
			l++;
			i++;
		}
		
		return Merged;
	}
	
	

}

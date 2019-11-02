package com.java.Sep8;

import java.util.Scanner;

public class ClassSep8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("enter num of rows");
		int row = sc.nextInt();
		System.out.println("enter num of col");
		int col = sc.nextInt();
		
		int arr[][] = new int[row][col];
		for(int rows=0;rows<row;rows++)
		{
			
			for(int cols=0;cols<col;cols++)
			{
				arr[rows][cols]=sc.nextInt();
			}
		}
		
		System.out.println("arrray is :");
		
		for(int rows=0;rows<row;rows++)
		{
			
			for(int cols=0;cols<col;cols++)
			{
				System.out.print(arr[rows][cols]+"  ");
			}
			System.out.println();
		}
		
		System.out.println();
		printInWaveForm(arr);
		//printInWaveFormVertical(arr);
		

	}
	
	
	public static void printInWaveForm(int arr[][])
	{
		int count=0;
		for(int row=0;row<arr.length;row++)
		{
			//int val=row+1;
			if(count%2==0)
			{

				for(int col=0;col<arr[0].length;col++)
				{
					System.out.print(arr[row][col]);
				}
			}
			else
			{
				for(int col=arr[0].length-1;col>=0;col--)
				{
					System.out.print(arr[row][col]);
				}
			}
			
			count++;
			System.out.println();
			
		}
		
	}
	
	public static void printInWaveFormVertical(int arr[][])
	{
		int count=0;
		for(int row=0;row<arr.length;row++)
		{
			//int val=row+1;
			if(count%2==0)
			{

				for(int col=0;col<arr[0].length;col++)
				{
					System.out.print(arr[col][row]);
				}
			}
			else
			{
				for(int col=arr[0].length-1;col>=0;col--)
				{
					System.out.print(arr[col][row]);
				}
			}
			
			count++;
			System.out.println();
			
		}
		
	}
	
}

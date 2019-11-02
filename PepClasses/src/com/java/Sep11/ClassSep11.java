package com.java.Sep11;

public class ClassSep11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[][]={
//				{1,2, 3,  4, 1,2},
//				{5,6, 7,  8, 1,2},
//				{9,10,11, 12,1,2},
//				{13,14,15,16,1,2}
		//};
		
		int arr[][]={
				{1,2, 3},
				{5,6, 7},
				{9,10,11}
				};
		
		//printMatrixTillDiagonal(arr, 0, arr.length-1);
		int diag[][] = null ;
		diag= transpose(arr);
		
		
		System.out.println("after print:  ");
		for(int i=0 ;i<diag.length;i++)
		{
			
			for(int j=0;j<diag[0].length;j++)
			{
				System.out.print(diag[i][j]+" ");
			}
			System.out.println();
		}
		
		diag = rotateMatrix(diag);
		
		System.out.println("after rotate:  ");
		for(int i=0 ;i<diag.length;i++)
		{
			
			for(int j=0;j<diag[0].length;j++)
			{
				System.out.print(diag[i][j]+" ");
			}
			System.out.println();
		}
		

	}
	
	public static void printMatrixTillDiagonal(int arr[][],int begin,int last)
	{
		int colitr=arr[0].length-1;
		int row=0;
		for(int i=begin;i<=colitr;i++)
		{	row=begin;
			for(int j=i;j<=colitr&&row<=last;j++)
			{
				System.out.print(arr[row++][j]+" ");
			}
			System.out.println();
		}
		
		
	}
	
	public static int[][] transpose(int arr[][])
	{
		
		int rows = arr.length;
		int cols = arr[0].length;
		
		 	
		
		for(int i=0;i<rows;i++)
		{
			
			for(int j=i;j<cols;j++)
			{
				
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		return arr;
	}
	
	public static int[][] rotateMatrix(int arr[][])
	{
		int rows = arr.length;
		int cols = arr[0].length;
		
		
		for(int i=0;i<rows;i++)
		{
		
			for(int j=0;j<cols/2;j++)
			{
				int temp = arr[i][j];
				arr[i][j]=arr[i][cols-j-1];
				arr[i][cols-j-1]=temp;
				
			}
		}
		
		return arr;
		
		
	}
	

}

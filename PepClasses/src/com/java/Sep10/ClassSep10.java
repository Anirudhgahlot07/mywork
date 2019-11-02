package com.java.Sep10;

public class ClassSep10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[][]={{1,2,3},{4,5,6},{7,8,9}};
		int arr2[][]={{1,2,3},{4,5,6},{7,8,9}};
		
		//int arr3[][]= additionOf2DArray(arr1, arr2);
		
		//int arr3[][]= multiplyOf2DArray(arr1, arr2);
		int arr3[][]={
				{ 0,1,0,0,1},
				 {1,0,0,0,0},
				 {0,0,1,0,0},
				 {0,1,0,0,1}
		};
		
		for(int i=0 ;i<arr3.length;i++)
		{
			
			for(int j=0;j<arr3[0].length;j++)
			{
				System.out.print(arr3[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("exit point is :");
		tellExitPoint(arr3);

	}
	
	
	public static   int[][]  additionOf2DArray(int arr1[][],int arr2[][])
	{
		if(arr1.length==arr2.length && arr1[0].length==arr2[0].length)
		{
			int row = arr1.length;
			int col = arr1[0].length;
			
			for(int i=0;i<row;i++)
			{
				
				for(int j=0;j<col;j++)
				{
					arr1[i][j]=arr1[i][j]+arr2[i][j];
					
				}
			}
		}
		
		
		return arr1;
	}
	
	public static int[][]  multiplyOf2DArray(int arr1[][],int arr2[][])
	{
		int row1 = arr1.length;
		int col1 = arr1[0].length;
		
		int row2 = arr2.length;
		int col2 = arr2[0].length;
		
		int mult=0;
		
		if(col1==row2)
		{
			int arr3[][] = new int[row1][col2];
			
			for(int i=0;i<row1;i++)
			{
				for(int j=0;j<col2;j++)
				{
					
					for(int m=0;m<col1;m++)
					{
						
						mult+=arr1[i][m]*arr2[m][j];
					}
					arr3[i][j]=mult;
					mult=0;
				}
			}
			
			return arr3;
		}
		
		return arr1;
	}
	
	public static String tellExitPoint(int arr[][])
	{
		int rowlen = arr.length;
		int collen = arr[0].length;
		
		
		int row=0;
		int col=0;
		int dir=0;
		while(true)
		{
			dir= (dir +arr[row][col])%4;
			if(dir==0)
			{
				col++;
				if(col==arr[0].length)
				{
					System.out.println(row+" "+ (col-1));
					break;
				}
					
				
			}
			else if(dir==1)
			{
				row++;
				if(row==arr.length)
				{
					System.out.println(row-1+" "+col);
					break;
				}
			}
			else if(dir==2)
			{
				col--;
				if(col==-1)
				{
					System.out.println(row+" "+(col+1));
					break;
					
				}
			}
			else if(dir==3)
			{
				row--;
				if(row==-1)
				{
					System.out.println(row+1+" "+col);
					break;
				}
			}
			
		}
		
		return null;
	}
}

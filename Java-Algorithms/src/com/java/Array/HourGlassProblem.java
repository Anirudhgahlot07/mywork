package com.java.Array;

import java.util.Scanner;

public class HourGlassProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter size of 2-d array");
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int breadth = len;
		int arr[][]  = new int[6][6];
		

	}
	
	static int hourglassSum(int[][] arr) {
		
		
		int prev=-99999,sum=-99999;
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				sum=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				sum=Math.max(prev, sum);
				prev=sum;
			}
		}
		
		return sum;


    }

}

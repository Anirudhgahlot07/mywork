package com.java.Patterns;

import java.util.Scanner;

public class AllPatterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Print the lenth of pattern");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//PatternofStarandNum(n);
		PatternofDoubleTimesStartWth3(n);
		
		sc.close();

	}
	
	public static void PatternofDoubleTimesStartWth3(int n)
	{
		int i =0;
		for(i =1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
			{
			System.out.print(2+i);
			}
			System.out.println("\n");
		}
		
		
		for(i=n;i>=1;i--)
		{
			for(int j=i;j>=1;j--)
			System.out.print(i+2);
			System.out.println("\n");
		}
		
		
	}
	
	public static void PatternofStarandNum(int n)
	{
		
		int prev=0; int j=0;
		for(int i =1;i<=n;i++)
		{
			if(i%2!=0)
			{
			for(j=1+prev;j<=i+prev;j++)
			{
				 if(j==i+prev)
					System.out.print(j);
				else
				System.out.print(j+"*");	
			}
			prev=j-1;
			}
			else
			{
				for(j=i+prev;j>=1+prev;j--)
				{
					 if(j==1+prev)
						System.out.print(j);
					else
					System.out.print(j+"*");	
				}	
				prev=i+prev;	
			}
			
			System.out.println("\n");
		}
		
	}

}

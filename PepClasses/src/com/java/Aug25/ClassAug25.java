package com.java.Aug25;

import java.util.Scanner;

public class ClassAug25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printStarPattern1(5);
		//printDiamondPattern(4);
		printDiamondPatternWithNum(4);
		//printFibonnaciInTriangle(4);
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		

	}
	
	public static void printStarPattern1(int n)
	{
		int star=1,space=n;
		
		for(int i=1;i<=n;i++)
		{
			
			for(int j=1;j<space;j++)
			{
				System.out.print(" ");
			}
			
			for(int j=1;j<=star;j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
			space--;
			star++;
			
		}
	}
	
	
		public static void printDiamondPattern(int n)
		{
			int star=1,space=n;
			
			
			for(int i=1;i<=n;i++)
			{
				for(int j=1;j<space;j++)
				{
					System.out.print(" ");
				}
				
				for(int j=1;j<=star;j++)
				{
					System.out.print("*");
				}
				
				System.out.println();
				space--;
				star=2*i+1;
				
			}
			star = (n-1)*2-1;
			space = n-1;
			for(int i=1;i<n;i++)
			{
				for(int j=1;j<=i;j++)
				{
					System.out.print(" ");
				}
				for(int j=star;j>=1;j--)
				{
					System.out.print("*");
				}
				System.out.println();
				star = star-2;
			}
			
		}
	
	public static void printDiamondPatternWithNum(int n)
	{
		int star=1,space=n;
		int printNum=0;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<space;j++)
			{
				System.out.print(" ");
			}
			
			for(int j=1;j<=star;j++)
			{
				if(j<=(star+1)/2)
					printNum++;
				else
					printNum--;
				System.out.print(printNum);
			}
			
			System.out.println();
			space--;
			star=2*i+1;
			
		}
		star = (n-1)*2-1;
		
		printNum=printNum-2;
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print(" ");
			}
			for(int j=star;j>=1;j--)
			{
				
				if(j>=(star+1)/2)
					printNum++;
				else
					printNum--;
				System.out.print(printNum);
				
	
			}
			System.out.println();
			star = star-2;
			printNum-=2;
		}
		
	}
	
	
	public static void printFibonnaciInTriangle(int n)
	{
		int val1=0,val2=0;
		int val=0;
		for(int i=0;i<n;i++)
		{
			
			for(int j=0;j<=i;j++)
			{
				if(i==0) 
				{
					System.out.print(val);
					
				}
				else if(i==1)
				{
					System.out.print(1);
					val1=1;
					val=2;
				}
				else	
				{
					
					System.out.print(val);

					val2=val1;
					val1=val;
					val = val1+val2;
				}
				
				
			}
			
			
			System.out.println();
				
		}
	}
	

}

package com.java.Aug27;

public class ClassAug27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//priOptimisedDaimondPattern(7);
			printOptimisedNumInDiaMond(5);
		//printOptimisedNumInDiamond2(7);
		//printHollowDiamond(5);
		//printOptimisedFibonnaciInTriangle(4);
		//pascalTriange(5);
		printCrossPattern(5);

	}
	
	
	public static void priOptimisedDaimondPattern(int n)
	{
		int star=1,space=n/2;
		
		for(int row=1;row<=n;row++)
		{
			
			for(int spc=1;spc<=space;spc++)
			{
				System.out.print(" ");
			}
			
			for(int str=1;str<=star;str++)
			{
				System.out.print("*");
			}
			System.out.println();
			
			if(row<=n/2)
			{
				space--;
				star+=2;
			}
			else
			{
				space ++;
				star-=2;
			}
			
		}
	}
	
	public static void printOptimisedNumInDiaMond(int n)
	{
		
		
		int space=n/2,numcnt=1;
		int val=1;
		
		for(int row=1;row<=n;row++)
		{
			
			for(int spc=1;spc<=space;spc++)
			{
				System.out.print(" ");
			}
			
			if(row-1<=n/2)
			val=row;
			else
				val=n-row+1;
			for(int num=1;num<=numcnt;num++)
			{
				System.out.print(val);
				if(num<=numcnt/2)
				{
					val++;
				}
				else
					val--;
			}
			System.out.println();
			
			if(row<=n/2)
			{
				space--;
				numcnt+=2;
				
			}
			else
			{
				space++;
				numcnt-=2;
				
				
			}
		}
		
	}
	
	public static void printOptimisedNumInDiamond2(int n)
	{
		
		int space=n/2;
		int numcount=1;
		
		for(int row=1;row<=n;row++)
		{
			
			for(int spc=1;spc<=space;spc++)
			{
				
				System.out.print(" ");
			}
			int val=row;
			if(row>n/2)
			{
				val = n-row+1;
			}
			
			for(int num=1;num<=numcount;num++)
			{
				
				System.out.print(val);
				if(num>numcount/2)
					val++;
				else
					val--;
			}
			
			if(row<=n/2)
			{
				space--;
				numcount+=2;
				
			}
			else
			{
				space++;
				numcount-=2;
			}
				
			
			System.out.println();
		}
	}
	
	public static void printHollowDiamond(int n)
	{
		int star=1;
		int space = n/2;
		
		for(int row=1;row<=n;row++)
		{
			for(int spc=0;spc<=space;spc++)
			{
				System.out.print("*");
			}
			
			for(int str=1;str<=star;str++)
			{
				System.out.print(" ");
			}
			for(int spc=0;spc<=space;spc++)
			{
				System.out.print("*");
			}
			
			System.out.println();
			if(row<=n/2)
			{
				space--;
				star+=2;
			}
			else
			{

				space++;
				star-=2;
			}
			
		}
		
	}
	
	public static void printOptimisedFibonnaciInTriangle(int n)
	{
		int a=0,b=1,sum=0;
		for(int row=1;row<=n;row++)
		{
			
			for(int j=1;j<=row;j++)
			{
				System.out.print(a);
				sum = a+b;
				a=b;
				b=sum;
				
			}
			System.out.println();
		}
	}
	
	
	static int fact(int n) 
	{ 
	    int num = 1; 
	    for (int i = 2; i <= n; i++) 
	        num = num * i; 
	    return num; 
	} 
	
	public static int factnPr(int n,int r)
	{
		if(n==1)
			return 1;
		else
			return fact(n)/fact(n-r);
	}
	
	public static int factnCr(int n,int r)
	{
		if(n==1)
			return 1;
		else
			return fact(n)/(fact(n-r)*fact(r));
	}
	
	public static void pascalTriange(int n)
	{
		
		for(int row=0;row<=n;row++)
		{
			int val=1;
			for(int j=0;j<=row;j++)
			{
				System.out.print(val);
				//if(row>0)
				val=(row-j)*val/(j+1);
			}
			System.out.println();
		}
	}
	
	public static void printCrossPattern(int n)
	{
		n=n-1;
		
		for(int row=0;row<=n;row++)
		{
			
			
			
			for(int j=n;j>=0;j--)
			{
				if((j==n-row || j==row ))
					System.out.print("*");
				else
					System.out.print(" ");
					
				
			}
			System.out.println();
		}
	}
}

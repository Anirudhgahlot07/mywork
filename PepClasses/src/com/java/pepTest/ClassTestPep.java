package com.java.pepTest;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ClassTestPep {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
			int size1,size2;
			
	        
	        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	        size1 = Integer.parseInt(buf.readLine());
	        PrintPattern3d(size1);
	        size2 =   Integer.parseInt(buf.readLine());
	        System.out.println(fact(size1));
	        System.out.println(factnPr(size1, size2));
	        System.out.println(factnCr(size1, size2));
	       /* String s1[] = buf.readLine().split(" ");
	        int arr1[]  = new int[size1]; 
	        for(int i=0;i<size1;i++)
	        {
	        	arr1[i]=Integer.parseInt(s1[i]);
	        }
	        
	        size2 = Integer.parseInt(buf.readLine());
	        String s2[] = buf.readLine().split(" ");
	        int arr2[]  = new int[size2]; 
	        for(int i=0;i<size2;i++)
	        {
	        	arr2[i]=Integer.parseInt(s2[i]);
	        }
	        
	        printSumOfArray(arr1, arr2);
	        */
	    }
	    
	
	
	public static int printreverseNum(int n)
	{
		
		
		int num=n;
		int count=0;
		int mult=1;
		while(n>0)
		{
			int rem = n%10;
			n=n/10;
			count++;
			mult=mult*10;
		}
		
		for(int i=1;i<=count;i++)
		{
			int rem= num%10;
			n+=rem*mult;
			mult/=10;
			num=num/10;
		}
		
		
		
		return n/10;
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
	
	
	public static void PrintPattern3d(int n)
	{
		int space = (n-1)*2-1;
		for(int i=1;i<=n;i++)
		{
			
			for(int j=1;j<=i;j++)
			{
				System.out.print(j);
			}
			
			for(int j=1;j<=space;j++)
			{
				System.out.print(" ");
			}
			
			for(int j=i;j>0;j--)
			{
				if(j!=n)
				System.out.print(j);
			}
			
			System.out.println();
			space-=2;
		}
	}
	
	public static void printSumOfArray(int arr1[] ,int arr2[])
	{
		int size1 = arr1.length;
		int size2 = arr2.length;
		int i=size1-1,j=size2-1;
		int curr=0,carry=0;
		String sum="";
		
			while(i>=0 && j>=0)
			{
				int num = arr1[i]+arr2[j]+carry;
				carry=0;
				if(num>9)
				{
					 curr = num%10;
					 carry = num/10;
				}
				else
					curr = num;
				sum=curr+sum;
				sum=" "+sum;
				i--;
				j--;
			}
			while(i>=0)
			{
				int num = arr1[i]+carry;
				carry=0;
				if(num>9)
				{
					 curr = num%10;
					 carry = num/10;
				}
				else
					curr=num;
				sum=curr+sum;
				sum=" "+sum;
				
				i--;
			}
			while(j>=0)
			{
				int num = arr2[j]+carry;
				carry=0;
				if(num>9)
				{
					 curr = num%10;
					 carry = num/10;
				}
				else
					curr = num;
				sum=curr+sum;
				sum=" "+sum;
				
				j--;
				
			}
		
	
		System.out.println(sum.substring(1,sum.length()));
	}
	
	
	public static void sumofOddAndEvenPlaceDigit(long num)
	{
		
		int count=0;
		int mult=1;
		
		num = Math.abs(num);
		long n=num;
		while(num>0)
		{
			long rem = num%10;
			num=num/10;
			count++;
			mult=mult*10;
		}
		long odd=0,even=0;
		
		for(int i=1;i<=count;i++)
		{
			if(i%2==0)
				even+=n%10;
			else
				odd+=n%10;
			n=n/10;
		}
		
		System.out.println(odd+" "+even);
	}
	
	public static void arrangeZerosAndOnesAndTwo(int arr[])
	{
		int size =arr.length;
		int zeroptr=0;
		int endptr =size-1;
		int i=0;
		while(i<=endptr)
		{
			//System.out.print(arr[i]+" ");
			if(arr[i]==0)
			{
				int temp=arr[i];
				arr[i]=arr[zeroptr];
				arr[zeroptr]=temp;
				zeroptr++;
				i++;
			}
			else if(arr[i]==2)
			{

				int temp=arr[i];
				arr[i]=arr[endptr];
				arr[endptr]=temp;
				endptr--;
				
			}
			else
				i++;
			
		}
		
		for(i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
}

package com.java.Sep1;

public class ClassSep1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[]={1,1,2,2,3,2,2,4,3,3,3,3,3};
		//int arr[] ={0,1,1,1,1,0,0,1};
		//int arr[] ={0,1,1,1,1,0,0,1,2,1,0};
		int arr[]={-2,-3,4,-1,-2,1,5,-3};
		//int arr[]={-4,2,1,8,-6,7,8,100};
		//System.out.println(tellNumWithHighestFreq(arr));
		//arrangeZerosAndOnes(arr);
		//arrangeZerosAndOnesAndTwo(arr);
		//printSubArray(arr);
		System.out.println(MaxSubArraySum(arr));
		MaxSubArraySumWithStartAndEndIndex(arr);
	}
	
	
	public static int tellNumWithHighestFreq(int arr[])
	{
		int size = arr.length;
		int freq=1;int j=1;
		int currElement=arr[0];
		for(int i=1;i<size;i++)
		{
			
			if(currElement==arr[i])
				freq++;
			else
				freq--;
			
			if(freq<=0)
			{
				currElement=arr[i];
				freq=1;
			}
		}
		
		freq=0;
		for(int i=0;i<size;i++)
		{
			if(currElement==arr[i])
				freq++;
			
		}
		if(freq>size/2)
			return currElement;
		else return -1;
		
		
	}
	
	public static void arrangeZerosAndOnes(int arr[])
	{
		int size =arr.length;
		int zeroptr=0;
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
			if(arr[i]==0)
			{
				int temp=arr[i];
				arr[i]=arr[zeroptr];
				arr[zeroptr]=temp;
				zeroptr++;
			}
		}
		System.out.println();
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void arrangeZerosAndOnesAndTwo(int arr[])
	{
		int size =arr.length;
		int zeroptr=0;
		int endptr =size-1;
		int i=0;
		while(i<=endptr)
		{
			System.out.print(arr[i]+" ");
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
		System.out.println();
		for(i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public  static void printSubArray(int arr[])
	{
		int size=arr.length;
		String s="";
		for(int i=0;i<size;i++)
		{
			for(int j=i;j<size;j++)
			{
				s+=arr[j];
				System.out.println(s);
			}
			s="";
		}
	}
	
	public static int MaxSubArraySum(int arr[])
	{
		int sum = Integer.MIN_VALUE;
		int currsum=0;
		int size = arr.length;
		
		for(int i=0;i<size;i++)
		{
			currsum+=arr[i];
				
			 if(currsum<arr[i])
				currsum=arr[i];
			sum = Math.max(currsum, sum);
		}
		return Math.max(currsum, sum);
	}
	
	public static void MaxSubArraySumWithStartAndEndIndex(int arr[])
	{
		int sum = Integer.MIN_VALUE;
		int currsum=0;
		int size = arr.length;
		int startInd=0,endInd=0;
		for(int i=0;i<size;i++)
		{
			currsum+=arr[i];
			
				
			 if(currsum<arr[i])
			 {
				currsum=arr[i];
				startInd=i;
			 }
			 if(currsum>=sum)
			 {
			sum = Math.max(currsum, sum);
			endInd =i;
			 }
		}
		System.out.println("start :"+startInd +" end is :"+endInd);
		
	}
	
}

package com.java.Strings;

import java.util.Scanner;

public class CountBinaryWithout1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter num");
		

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		//System.out.println(toBinary(0));
		
		int size = (int) (Math.pow(2, num)-1);
		String str[]= new String[size];
		str =generatenumbers(num);
		
		for(int i =0;i<size;i++)
		{
			if(str[i]!=null && !str[i].equals(""))
				System.out.println(str[i]);
		}
		sc.close();
	}
	
	
	static String toBinary(int num)
	{
		String str="";
		
		if(num==0)
			return "0";
		else
		{
		while(num/2>0)
		{
			str+=num%2;
			num=num/2;
			
		}
		if(num==1)
			str+="1";
		
		return reverse(str);
		}
	}
	
	static String reverse(String str)
	{
		int len = str.length();
		int n = len/2;
		char charArry[]=str.toCharArray();
		for(int i=0;i<n;i++)
		{
			char temp =charArry[i];
			charArry[i]=charArry[len-1-i];
			charArry[len-1-i]=temp;
			
		}
		str=String.valueOf(charArry);
		return str;
	}
	 
	static  boolean checkconsecutive1(String str)
	{
		boolean flag=false;
		int len = str.length();
		for(int i =0;i<len-1;i++)
		{
			if(str.charAt(i)=='1' &&str.charAt(i+1)=='1')
			{	flag=true;
				break;
			}
			else
				flag=false;
		}
		return flag;
	}
	
	static String[] generatenumbers(int n)
	{
		int limit = (int) (Math.pow(2, n)-1);
		
		String stra[]=new String[limit];
		int count=0;
		int diff=0;
		String str="";
		int len=0;
		for(int i=0;i<=limit;i++)
		{
			str=toBinary(i);
			if(!checkconsecutive1(str))
			{
				stra[count]=str;
			
			 len=stra[count].length();
			if(len<n)
			{
				diff=n-len;
				while(diff>0)
				{
					stra[count]="0"+stra[count];
					diff--;
				}
				
			}
			}
			
			count++;
		}
		
		return stra;
	}
}

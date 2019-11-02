package com.java.Strings;

import java.util.Scanner;

public class RemoveSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("enter string to process");
		
		Scanner sc = new Scanner(System.in);
		String str = null;
	
		str = sc.nextLine();
		
		//removeAllspaces(str);
		str =removeSpace(str);
		
		
		System.out.println();
		System.out.println(str);
		
		
		
		
	}

	
	static String removeSpace(String str)
	{
		 int len = str.length();
		 char starr[] = str.toCharArray();
		 
		 int n=0,count=0;
		 boolean doubspace=false;
		 for(int i =0;i<len-1; i++)
		 {
			 if(starr[i]==' ' && starr[i+1]==' ')
			 {
				 doubspace=true;
			 }
			 else
				 doubspace=false;
			 if(!doubspace)
				 starr[count++]=starr[i];
		 }
		 
		 str = String.valueOf(starr);
		 str=str.substring(0, count);
		 return str;
	}
	
	static int removeAllspaces(String str)
	{
		
		int len = str.length();
		char[] charArr = str.toCharArray();
		int curr=0 ;
		
		for(int i =0;i<len ;i++)
		{
			if(charArr[i]!=' ')
			charArr[curr++]=charArr[i];
		}
		str=String.valueOf(charArr);
		str=str.substring(0, curr);
		System.out.println(str);
		
		return curr;
		
	}
	
	
	static int deleteArray(char arr[],int index)
	{
		int n = arr.length;
		
	
		int i;
		for(i=index;i<n-1 ;i++)
		{
			arr[i]=arr[i+1];
			
			
			
		}
		
		if(i<0)
			return 0;
		
			
		
		return n-1;
	}
	
}

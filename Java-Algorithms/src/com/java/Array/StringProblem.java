package com.java.Array;

import java.util.Arrays;

public class StringProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str[]={"eva", "jqw", "tyn", "jan"};
		System.out.println(Solution1(str));
		///	System.out.println(Solution("codility"));
	}
	
	
	static public String Solution(String S)
	{
			int len = S.length();
			
			String arr[]  = new String[len];
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<len;i++)
			{
				for(int j=0;j<len;j++)
				{
					if(i!=j)
						sb.append(S.charAt(j));
						
				}
				arr[i]=sb.toString();
				sb=new StringBuilder();
				
			}
			
			Arrays.sort(arr);
			return arr[0];
	}
	static public int Solution1(String []A)
	{
		int len = A.length;
		int max=0;
		int count=0;
		for(int i=0;i<len;i++)
		{
			
			for(int j=i+1;j<len;j++)
			{
				String temp = A[i]+A[j];
				char[]  c = new char[26];
				
				for(int k=0;k<temp.length();k++)
				{
					c[temp.charAt(k)-'a']++;
				}
				int length=0;
				for(int k=0;k<c.length;k++)
				{
					if(c[k]>0)
						length++;
					if(c[k]>1)
					{
						length=0;
						break;
					}
				}
				if(length==max)
					count++;
				else if(length>max)
				{
					max=length;
					count=1;
					
				}
				
			}
		}
	
		
		
		
		return max;
	}
	
	

}

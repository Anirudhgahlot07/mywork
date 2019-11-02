package com.java.sep29;

import java.util.ArrayList;

public class classSep29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[]={"eva", "jqw", "tyn", "jan"};
		System.out.println(biggestCountOfUniqueString(printAllcombi(str)));
	}
	
	
	public static ArrayList<String> printAllcombi(String arr[])
	{
		ArrayList<String> al = new ArrayList<>();
		al.add("");
		
		for(int i=0;i<arr.length;i++)
		{
			ArrayList list2 = new ArrayList<>();
			for(String s:al)
			{
				list2.add(s);
				list2.add(s+arr[i]);
			}
			
			al = list2;
		}
		
		return al;
		
	}
	
	
	public static int biggestCountOfUniqueString(ArrayList<String> list)
	{
		
		int count =0;
		String ans="";
		int max=Integer.MIN_VALUE;
		for(int i=0;i<list.size();i++)
		{
			String curr=list.get(i);
			int arr[] = new int[26];
			count=0;
			for(int j=0;j<curr.length();j++)
			{
				arr[curr.charAt(j)-'a']++;
				if(arr[curr.charAt(j)-'a']>1)
				{
					count=0;
				
					break;
				}
				else
					count++;
			}
			if(count>max)
			{
				max=count;
				ans=curr;
				
			}
		}
		System.out.println("string is : "+ans);
		return max;
		
	}
}

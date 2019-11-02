package com.java.Strings;

import java.util.Arrays;

public class LongestNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="geeksforgeeks";
		//firstNonRepeating(6, str);
		System.out.println(LongestNonRepeating(str));
		
		
	}
	
	
		static int LongestNonRepeating(String str)
		{
			int arr[]  = new int[26];
			Arrays.fill(arr, -1);
			int count=0,start=0,max=Integer.MIN_VALUE;
			
			for(int i=0;i<str.length();i++)
			{
				if(arr[str.charAt(i)-'a']==-1 )
				{
					arr[str.charAt(i)-'a']=i;
					count++;
				}
				else if(arr[str.charAt(i)-'a']<start)
				{
					count++;
					arr[str.charAt(i)-'a']=i;
				}
				else	
				{
					start=arr[str.charAt(i)-'a']+1;
					arr[str.charAt(i)-'a']=i;
					count++;
					//arr[str.charAt(i)-'a']=-1;
					
				
				}
					
				max=Math.max(max, count-start);
			}
			return max;
			
		}

}

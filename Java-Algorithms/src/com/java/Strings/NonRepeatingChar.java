package com.java.Strings;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="geeksforgeeks";
		//firstNonRepeating(6, str);
		System.out.println(firstNonRepeating(str));
		

	}
	
	static int firstNonRepeating(String str)
	{
		int arr[]  = new int[26];
		Arrays.fill(arr, -1);
		int count=0,max=Integer.MIN_VALUE,lastindex=-1;
		
		for(int i=0;i<str.length();i++)
		{
			if(arr[str.charAt(i)-'a']==-1 )
			{
				arr[str.charAt(i)-'a']=i;
				count++;
			}
			else if(arr[str.charAt(i)-'a']<lastindex && lastindex!=-1)
			{
				count++;
			}
			else
				
			{
				arr[str.charAt(i)-'a']=-2;
				max=Math.max(count, max);
				count=0;
				arr[str.charAt(i)-'a']=-1;
				lastindex=i;
				i--;
			}
				
			
		}
		return Math.max(max,count);
		
	}

	static String firstNonRepeating(int size,String str)
	{
	    LinkedHashMap<String,Integer> hmap = new LinkedHashMap<String,Integer>(26);
	    
	    for(int i=0;i<size;i++)
	    {
	    	Integer val=hmap.get(String.valueOf(str.charAt(i)));
	    	if(val!=null)
	    	{
	     
	        hmap.put(String.valueOf(str.charAt(i)),val+1);
	    	}
	    	else
	    	{
	    		hmap.put(String.valueOf(str.charAt(i)),1);
	    		
	    	}
	    		
	    }
	    
	    Iterator it=hmap.entrySet().iterator();
	    while(it.hasNext())
	    {
	    	Map.Entry<String, Integer> entry = (Entry<String, Integer>) it.next();
	    	if(entry.getValue()==1)
	    	{
	    		return entry.getKey();
	    		
	    	}
	    		
	    	
	    }
	    return "-1";
	    
	    
	}

}

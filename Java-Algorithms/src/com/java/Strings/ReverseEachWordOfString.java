package com.java.Strings;

import java.util.LinkedHashMap;

public class ReverseEachWordOfString {

	public static void main(String[] args) {
		
		String s ="I love programming very much";
		System.out.println(ReverseEach(s));
		System.out.println(ReverseWords(s));

	}
	
	static String ReverseEach(String s)
	{
		String op="",last="";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)!=' ')
				op = s.charAt(i)+op;
			else
			{
				last+=op;
				last=last+" ";
				op="";
			}
		}
		last+=op;
		return last;
	}
	
	static String ReverseWords(String s)
	{
		String op="",last="";
		
		for(int i=s.length()-1;i>=0;i--)
		{
			if(s.charAt(i)!=' ')
				op = s.charAt(i)+op;
			else
			{
				last+=op;
				last=last+" ";
				op="";
			}
			
		}
		last +=op;
		
		return last;
		
	}
	
	
	static void firstNonRepeating(int size,String str)
	{
	    LinkedHashMap<String,Integer> hmap = new LinkedHashMap(26);
	    
	    for(int i=0;i<size;i++)
	    {
	    	if(hmap.get(str.charAt(i))!=null)
	    	{
	        int val = hmap.get(str.charAt(i));
	        hmap.put(String.valueOf(str.charAt(i)),val++);
	    	}
	    	else
	    	{
	    		hmap.put(String.valueOf(str.charAt(i)),1);
	    		
	    	}
	    		
	    }
	    
	}

}

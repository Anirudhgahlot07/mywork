package com.java.sep21;

import java.util.ArrayList;

public class recursion4 {

	static int call=0;
	static String arr[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wx","yz","*","0+","#"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//printKeyPad("235", "");
		//System.out.println("abc".substring(1,2));
		//ArrayList<String> al = printPathIncludingDiagonal(0,0,2,2);
//		ArrayList<String> al = printAllPossiblePathFromAnyhere(0,0,2,2);
		//tellSubSequenceUsingVoid("abc", "");
		//printAllPermUsingVoid("abc","");
		int arr[] = new int[26];
		printKeyPad("235", "");
		System.out.println("before keypad :");
		//printAllPermUsingVoid("aab", "");
		//printAllPermUsingVoidNonRepeat("aab", "");
		/*ArrayList<String> al = tellPossibity(10, 0);
		System.out.println(al.size());
		for(String s:al)
		{
			System.out.println(s+" ");
		}
		*/
		//System.out.println(boardPath(0, 10, ""));
		//System.out.println(MazeProblemWithDaigonalTotalCalls(0, 0, 2, 2, 1,1));
		//System.out.println(call);
		int bool = 1;
		int isset =0;
		bool=1<<'b';
		System.out.println(bool&isset);
		isset|=bool;
		System.out.println(isset);
		System.out.println(bool&isset);
		//bool&=1;
		//System.out.println(bool|'b');
		
	}
	
	
	public static ArrayList<String> printPathIncludingDiagonal(int beginrow,int begincol,int endrow,int endcol)
	{
		if(begincol==endcol && beginrow==endrow)
		{
			ArrayList<String>  li = new ArrayList<>();
			li.add("");
			return li;
			
		}
		
		ArrayList<String>  ansList = new ArrayList<>();
		
		
		if(begincol+1<=endcol)
		{
			ArrayList<String> colList = printPathIncludingDiagonal(beginrow, begincol+1, endrow, endcol); 
			
			for(String s:colList)
			{
				ansList.add('V'+s);
				
			}
			
			
		}
		
		if(beginrow+1<=endrow)
		{
			
			ArrayList<String> rowList = printPathIncludingDiagonal(beginrow+1, begincol, endrow, endcol);
			for(String s:rowList)
			{
				ansList.add('H'+s);
			}
			
		}
		
		
		if(beginrow+1<=endrow && begincol+1<=endcol) 
		{
			
			ArrayList<String> diagList = printPathIncludingDiagonal(beginrow+1, begincol+1, endrow, endcol);
			for(String s:diagList)
			{
				ansList.add('D'+s);
			}
			
		}
		
		return ansList;
	}
	
	public static ArrayList<String>  printAllPossiblePathFromAnyhere(int beginrow, int begincol, int endrow, int endcol)
	{
		if(beginrow==endrow  && begincol==endcol)
		{
			
			ArrayList<String>  li = new ArrayList<>();
			li.add("");
			return li;
		}
		
		ArrayList<String>  ansList = new ArrayList<>();
		
		for(int  jump=1;jump+begincol<=endcol;jump++)
		{
			
			ArrayList<String> resCol = printAllPossiblePathFromAnyhere(beginrow, begincol+jump, endrow, endcol);

			for(String s:resCol)
			{
				ansList.add("H"+jump+s);
				
			}
			
		}
		
		for(int  jump=1;jump+beginrow<=endrow;jump++)
		{
			
			ArrayList<String> resCol = printAllPossiblePathFromAnyhere(beginrow+jump, begincol, endrow, endcol);

			for(String s:resCol)
			{
				ansList.add("V"+jump+s);
				
			}
			
		}
		
		for(int  jump=1;jump+beginrow<=endrow && jump+begincol<=endcol;jump++)
		{
			
			ArrayList<String> resCol = printAllPossiblePathFromAnyhere(beginrow+jump, begincol+jump, endrow, endcol);

			for(String s:resCol)
			{
				ansList.add("D"+jump+s);
				
			}
			
		}
		
		
		return ansList;
		
		
		
	}
	
	public static ArrayList<String> tellPossibity(int final_num,int num )
	{
		if(num==final_num)
		{
			ArrayList<String> li = new ArrayList<String>();
			li.add("");
			return li;
		}
		
		
		ArrayList<String> ansList = new ArrayList<String>();
		for(int i=1;i<=6 && i+num<=final_num;i++)
		{
			ArrayList<String>  res = tellPossibity(final_num, i+num);
			for(String s:res)
			{
				ansList.add(s+i);
			}
		}
		
		return ansList;
	}
	
	public static void tellSubSequenceUsingVoid(String str,String ch)
	{
		if(str.length()==0)
		{
			
			System.out.println(ch+"");
			return;
		}
		
		char first_char = str.charAt(0);
		String rem = str.substring(1);
		 tellSubSequenceUsingVoid(rem, first_char+ch);
		 tellSubSequenceUsingVoid(rem, ch);
		
	}
	
	public static void printAllPermUsingVoid(String str,String ans)
	{
		if(str.length()==0)
		{
			
			System.out.println(ans);
			return;
		}
		
		
		for(int i=0;i<str.length();i++)
		{
			String one = str.substring(0,i);
			String two = str.substring(i+1);
			printAllPermUsingVoid(one+two, str.charAt(i)+ans);
			
		}	 
			
	}
	
	
	public static void printAllPermUsingVoidNonRepeat(String str,String ans)
	{
		if(str.length()==0)
		{
			
			System.out.println(ans);
			return;
		}
		
		int arr[] = new int[26]; 
		int bool=1;
		for(int i=0;i<str.length();i++)
		{
			
			String one = str.substring(0,i);
			String two = str.substring(i+1);
			arr[str.charAt(i)-'a']++;
			bool=bool<<(str.charAt(i)-'a');
			if(arr[str.charAt(i)-'a']<=1)
			{
			printAllPermUsingVoidNonRepeat(one+two, str.charAt(i)+ans);
			}
			
		}	 
			
	}
	
	public static int boardPath(int start,int dest,String ans)
	{
		if(start==dest)
		{
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		for(int i=1;i<=6&& i+start<=dest;i++)
		{
			count+=boardPath(start+i, dest, ans+i);
			
		}
		return count;
	}
	
	
	   public static int MazeProblemWithDaigonalTotalCalls(int beginrow,int begincol,int endrow,int endcol,int cal1,int total)
	    {	
		   		call++;
	            if(begincol==endcol && beginrow==endrow)
	            {
	                //System.out.println(call);
	                return total;
	            }

	            int count=0;
	            int h1=0,h2=0,h3=0;

	            if(beginrow+1<=endrow)
	            {	
	            	total=MazeProblemWithDaigonalTotalCalls(beginrow+1, begincol, endrow, endcol, h1,total)+1;
	            	
	            	System.out.println("h1 is : " +total);
	            }

	            if(begincol+1<=endcol)
	            {	
	            	total=MazeProblemWithDaigonalTotalCalls(beginrow, begincol+1, endrow, endcol, h2,total)+1;
	            	
	            	System.out.println("h2 is : " +total);
	            }

	            if(begincol+1<=endcol && beginrow+1<=endrow) 
	            {
	            	total=MazeProblemWithDaigonalTotalCalls(beginrow+1, begincol+1, endrow, endcol, h3,total)+1;
	            	
	            	System.out.println("h3 is : " +total);
	            }
	            
	            return total;


	    }
	   
	   public static void printKeyPad(String keypad,String ans)
	   {
		   if(keypad.length()==0)
		   {
			   
			   System.out.println(ans);
			   return ;
		   }
		   
		   char ch = keypad.charAt(0);
		   String rem = keypad.substring(1);
		   String code = arr[ch-'0'];
		   
		   for(int i=0;i<code.length();i++)
		   {
			  
		   		
			   printKeyPad(rem, ans+code.charAt(i));
			   
			   
			   
		   }
		 
	   }

}

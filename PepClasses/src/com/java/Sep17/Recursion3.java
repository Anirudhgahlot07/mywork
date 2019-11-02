package com.java.Sep17;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Recursion3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String str="123";
		ArrayList<String> al = printAllPerm(str);
		//ArrayList<String> al = printPath(0,0,3,3);
		for(String s:al)
		{
			System.out.print(s+" ");
		}

	}


	public static ArrayList<String>  subseq(String str)
	{
		if(str.length()==0)
		{

			ArrayList<String> li = new ArrayList();
			li.add("");
			return li;
		}

		char ch = str.charAt(0);
		String restStr=str.substring(1);

		ArrayList<String> list =subseq(restStr);
		ArrayList<String> myAns = new ArrayList();

		for(String s:list)
		{
			myAns.add(s);
			myAns.add(ch+s);
		}
		return myAns;

	}

	public static ArrayList<String>  printAllPerm(String str)
	{
		if(str.length()==0)
		{

			ArrayList<String> li = new ArrayList();
			li.add("");
			return li;
		}

		char ch = str.charAt(0);
		String restStr=str.substring(1);

		ArrayList<String> listans =printAllPerm(restStr);
		ArrayList<String> myAns = new ArrayList();

		for(String s:listans)
		{
			for(int i=0;i<=s.length();i++)
			{
				String one = s.substring(0,i);
				String two = s.substring(i);
				String ans = one+ch+two;
				myAns.add(ans);
			}
		}
		return myAns;

	}

	public static ArrayList<String>  printPath(int rowbegin,int colbegin,int colend,int rowend)
	{

		if(rowbegin== rowend && colbegin==colend)
		{
			ArrayList li = new ArrayList<String>();
			li.add("");
			return li;
		}

		ArrayList<String>  resList = new ArrayList<>();

		if(colbegin+1<=colend)
		{

			ArrayList<String> colLost = printPath(rowbegin, colbegin+1, colend, rowend);
					for(String s:colLost)
					{
						resList.add('h'+s);
					}
		}

		if(rowbegin+1<=rowend)
		{

			ArrayList<String> rowLost = printPath(rowbegin+1, colbegin, colend, rowend);
					for(String s:rowLost)
					{
						resList.add('v'+s);
					}
		}
		
		
		return resList;
 
	}
}

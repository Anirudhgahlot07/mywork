package com.java.Strings;

import java.util.Scanner;

public class LongestPalindromeLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter string to process");
		
		Scanner sc = new Scanner(System.in);
		String str = null;
	
		str = sc.nextLine();

		System.out.println(LongestPal(str));
		sc.close();
	}
	
	static int LongestPal(String str)
	{
		int len = str.length();
		int maximum = 0;
		
		boolean store[][] = new boolean[len][len];
		
		for(int i =0 ; i<len;i++)
		{
			store[i][i]=true;
			maximum=1;
		}
		
		for(int i =0 ; i<len-1;i++)
		{
			if(str.charAt(i)==str.charAt(i+1))
			{
			store[i][i+1]=true;
			maximum=2;
			}
		}
		
		//int k=0;
		for(int i =3;i<=len;i++)
		{
			for(int j=0;j<len-i+1;j++)
			{
				int  k=i+j-1;
				if(store[j+1][k-1] && str.charAt(j)==str.charAt(k))
				{
					store[j][k]=true;
					
					if(i>maximum)
					maximum=i;
				}
			}
		}
		
		return maximum;
		
	}

}

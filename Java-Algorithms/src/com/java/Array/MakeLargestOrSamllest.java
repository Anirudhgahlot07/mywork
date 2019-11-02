package com.java.Array;

public class MakeLargestOrSamllest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(TellLargest(1111111211));
		System.out.println(tellSmallest(1111111211));
	}
	
	static int TellLargest(int num)
	{
		int temp = num;
		int count[] = new int[10];
		int ch=0;
		
		while(temp>0)
		{
			int  digit  = temp%10;
			count[digit]++;
			temp=temp/10;
			
		}
		
		int len = count.length;
		int numb=0,multi=1;
		for(int i=0;i<len;i++)
		{
			if(count[i]>0)
			{
			numb = numb+(multi*i);
			count[i]--;
			i--;
			multi=multi*10;
			}
			
		}
				
				
		
		
		return numb;
	}
	
	static int tellSmallest(int num)
	{

		int temp = num;
		int count[] = new int[10];
		
		
		while(temp>0)
		{
			int  digit  = temp%10;
			count[digit]++;
			temp=temp/10;
			
		}
		
		int len = count.length;
		int numb=0,multi=1;
		for(int i=len-1;i>=0;i--)
		{
			if(count[i]>0)
			{
			numb = numb+(multi*i);
			count[i]--;
			i++;
			multi=multi*10;
			}
			
		}
				
				
		
		
		return numb;
	
	}

}

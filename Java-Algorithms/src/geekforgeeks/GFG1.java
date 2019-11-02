package geekforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class GFG1 {


	public static void main (String[] args) throws Exception{
		//code
		BufferedReader buf = new BufferedReader (new InputStreamReader(System.in));
		int test =  Integer.parseInt(buf.readLine());
	//	int num =  Integer.parseInt(buf.readLine());
		
		//PrintPrime(num);
		
		while(test>0)
		{
			int size =  Integer.parseInt(buf.readLine());
			size=size*2+2;
			String str = buf.readLine();
			String sarr[]  = new String[size];
			sarr  = str.split(" ");
			long arr[]  = new long[size];

			for(int i=0;i<size;i++)
			{
				arr[i]=Long.parseLong(sarr[i]);
			}
			
			findDistinctNum(arr, size);
			//System.out.println(repeatingNum(arr, size));
			//StockBuySell(arr,size);
		//	System.out.println(telldiff(sarr, 0, size));
			

			test--;
		}


	}
	
	static void  PrintarrElements(String str[],String str2[],int size1,int size2)
	{
		int i=0,j=0;
		
		while(i<size1 && j<size2)
		{
			
			System.out.print(str[i++]+" ");
			System.out.print(str[j++]+" ");
		}
		
		while(i<size1)
		{
			
			System.out.print(str[i++]+" ");
			//System.out.print(str[j++]+" ");
		}
		
		while(j<size2)
		{
			System.out.print(str[j++]+" ");
		}
		
		System.out.println();
	}
	static void TellUpAndDown(String str[],int size)
	{
		int ups=0,downs=0;
		
		for(int i=1;i<size-1;i++)
		{
			if(i-1>=0 && i+1<=size-1 && Integer.parseInt(str[i])>Integer.parseInt(str[i-1]) && Integer.parseInt(str[i])>Integer.parseInt(str[i+1]))
			{
				ups++;
			}
			
			if(i-1>=0 && i+1<=size-1 && Integer.parseInt(str[i])<Integer.parseInt(str[i-1]) && Integer.parseInt(str[i])<Integer.parseInt(str[i+1]))
			{
				downs++;
			}
			
			
		}
		System.out.println(ups+" "+downs);
	}
	
	static void findDistinctNum(long arr[],int size)
	{
		HashMap<Long, Integer> hmap = new HashMap<>();
		long first=Long.MIN_VALUE,second=0;
		
		for(int i=0;i<size;i++)
		{
			if(hmap.get(arr[i])==null)
				hmap.put(arr[i], 1);
			else
				hmap.put(arr[i], hmap.get(arr[i])+1);
				
		}
		
		for(int i=0;i<size;i++)
		{
			if(hmap.get(arr[i])%2==1)
			{
				if(first==Long.MIN_VALUE)
					first=arr[i];
				else
				{
					if(arr[i]<=first)
					{
						long temp = first;
						first=arr[i];
						second=temp;
	
					}
					else
					{
						second=arr[i];
						break;
					}
					
				}
						
				
			}
				
				
		}
		
		System.out.println(first+" "+second);
		
				
	}
	
	static void PrintPrime(int num)
	{
		int root = (int)Math.sqrt(num);
		String s="";
		
		for(int i=2;i<=root+1;i++)
		{
			if(i!=2)
			{
				if(i%2!=0)
				{
					if(isPrime(i)&& isPrime(num-i))
						s=(i+" "+(num-i));
				}
			}
			else
			{
				if(isPrime(num-2))
				{
					s=(2+" "+(num-2));
				break;
				}
			}
		}
		
		System.out.println(s!=""?s:"-1");
		
	}
	static boolean isPrime(int num)
	{
		
		int root = (int)Math.sqrt(num);
		
		for(int i=2;i<=root;i++)
		{
			if(num%i==0)
				return false;
		}
		return true;
	}
	
	
	static int telldiff(String arr[],int init,int size)
	{
	    
	    int i=init,j=size-1,max=0,curr_max=0;
	    for(i=init;i<size-1;i++)
	    {
	    	while(i<=j)
	    	{
	    		if(Long.parseLong(arr[i])<=Long.parseLong(arr[j]))
	    		{
	    			curr_max=j-i;
	    			j=size-1;
	    			break;
	    		}
	    		else
	    			j--;
	    			
	    	}
	    	max=Math.max(curr_max, max);
	    }
	    
	    return Math.max(curr_max, max);
	        
	}
		static void  StockBuySell(int arr[],int size)
		{
			int j=0,start_index=0,end_index=0,count=0;
			String s="";
			for(int i=0;i<size-1;)
			{
				j=i+1;
				if(arr[j]>arr[i])
				{
					start_index=j;
					++count;
				}
				else
				{
					if(start_index!=0)
					{
					end_index=start_index;
					start_index=start_index-count;
					s+="("+start_index+" "+end_index+")"+" ";
					}
					count=0;
					start_index=0;
					end_index=0;
				}
				i++;
			}
			
			if(start_index!=0)
			{
				end_index=start_index;
				start_index=start_index-count;
				s+="("+start_index+" "+end_index+")";
				
			}
			System.out.println(s!=""?s:"No Profit");
			
		}

		

}

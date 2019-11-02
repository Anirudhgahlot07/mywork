package geekforgeeks;


import java.util.*;
import java.lang.*;
import java.io.*;

class SumofPrimeTillanyN {
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int test = Integer.parseInt(br.readLine());
		int len = test;
		long inp[] = new long[test];
		long tobeSorted[] = new long[test];
		int count=0;
		long max=Long.MIN_VALUE;
		while(test>0)
		{
		    long num = Long.parseLong(br.readLine());    
		    inp[count]=num;
		    tobeSorted[count]=num;
		    
		    
		    if(inp[count]>max)
		    	max=inp[count];
		    
		    count++;
		    test--;
		}
		boolean primarr[] = isPrime(max);
		Arrays.sort(tobeSorted);
		HashMap<Long,Long> hashMap = new HashMap<>();
		hashMap =fillHashArray(hashMap, primarr, tobeSorted);
		
		for(int i=0;i<len;i++)
		{
			System.out.println(hashMap.get(inp[i]));
		}
	}
	
	
	static boolean[] isPrime(long n)
	{
		boolean prime[]  = new boolean[(int)n+1];
	    Arrays.fill(prime, true);
	    
		
	    for(int i=2;i*i<=n;i++)
	    {
	        if(prime[i])
	        {
	        	for(int j=i*i;j<=n;j=j+i)
	        	{
	        		prime[j]=false;
	        	}
	        	
	        }
	             
	    }
	    
	    return prime;
	}
	
	static HashMap<Long, Long> fillHashArray(HashMap<Long,Long>hashMap ,boolean boolarr[],long arr[])
	{
		int len = arr.length;
		long sum=0;
		long index=2;
		for(int i=0;i<len;i++)
		{
			for(int j=(int)index;j<=arr[i];j++)
			{
				if(boolarr[j])
					sum+=j;
			}
			hashMap.put(arr[i], sum);
			index=arr[i]+1;
		}
		
		return hashMap;
		
	}
	
}
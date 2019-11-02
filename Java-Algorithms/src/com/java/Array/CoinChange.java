package com.java.Array;

public class CoinChange {

	
	 static long getWays(long n, long[] c) {

	        long coinlen = c.length;
	       
	        long table[]  = new long[(int) (n+1)];

	        if(n==0)
	        return 1;

	        table[0]=1;

	        for(int i=0;i<coinlen ;i++)
	        {
	            for(int j=1;j<=n;j++)
	            {
	            	if(j>=c[i])
	                table[j]+=table[(int) (j-c[i])];
	            }
	        }

	      return table[(int) n];

	    }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long[] c={2 ,5};
		System.out.println(getWays(9, c));
	}

}

package geekforgeeks;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class BitDifference {
	public static void main (String[] args) throws Exception{

		int arr1[]={1,2,3,4,5};
		int d=7;
		arr1 =rotateArr(arr1, d%5);	
		
		
    BufferedReader buf = new BufferedReader (new InputStreamReader(System.in));
    int test =  Integer.parseInt(buf.readLine());
    
    while(test>0)
    {
        String str = buf.readLine();
        String arr[]  = str.split(" ");
       // int count=0;
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
       /* int xor=num1^num2;
        while(xor>0)
        {
        	if((xor&1)==1)
        		count++;
        		xor=xor>>1;
        	
        		
        }
        System.out.println(count);*/
        //System.out.println(num1^num2);
        System.out.println(flips(num1,num2));
        test--;
    }
	}
	

	 static int[]  rotateArr(int arr[],int d)
		{
		    int len = arr.length;
		    while(d>0)
		    {
		        int temp=0,temp2=0,i=0;
		    for(i=len-1;i>0;i--)
		    {
		        if(i<len-1)
		        {
		        	temp2=arr[i-1];
		            arr[i-1]=temp;
		            temp=temp2;;
		        }
		        else
		        {
		        temp = arr[i-1];
		        arr[i-1]=arr[i];
		        }
		        
		    }
		    arr[i-1+len]=temp;
		    d--;
		    }
		    
		    return arr;
		}
	
	static int flips(int num1,int num2)
	{
	    int count=0,len=0,flips=0;
	    String bin1="";
	    String bin2="";
	    if(num2>num1)
	    {
	        int temp = num1;
	        num1=num2;
	        num2=temp;
	    }
	    
	    if(num1>num2)
	    {
	         while(num1>0)
	         {
	             
	             while(num2>0)
	             {
	            
	             bin2=bin2+num2%2;
	             bin1=bin1+num1%2;
	             num1=num1/2;      
	             num2=num2/2;
	             count++;
	             len++;
	             }
	             
	             if(num1>0)
	             {
	            bin1=bin1+num1%2;	 
	            bin2=bin2+0;
	            num1=num1/2;
	             
	             count++;
	             }
	         }
	         System.out.println(bin1);
	         System.out.println(bin2);
	         for(int i=0;i<count;i++)
	         {	
	        	 if(bin1.charAt(i)!=bin2.charAt(i))
	        		 flips++;
	        	 
	        	 	//if(i>=len  && bin1.charAt(i)!=0)
	        	 	/*if(i>=len)
	        	 		flips++;*/
	         }
	         
	    }
	    return flips;
	}
}
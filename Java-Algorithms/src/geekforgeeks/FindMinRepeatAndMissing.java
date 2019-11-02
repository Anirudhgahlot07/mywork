package geekforgeeks;

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class FindMinRepeatAndMissing {
	public static void main (String[] args) throws Exception{
		//code
		BufferedReader buf = new BufferedReader (new InputStreamReader(System.in));
		int test =  Integer.parseInt(buf.readLine());

		while(test>0)
		{
			int size =  Integer.parseInt(buf.readLine());
			String str = buf.readLine();
			String sarr[]  = new String[size];
			sarr  = str.split(" ");
			int arr[]  = new int[size];

			for(int i=0;i<size;i++)
			{
				arr[i]=Integer.parseInt(sarr[i]);
			}

			//System.out.println(repeatingNum(arr, size));
			find(arr,size);
			
			int curr_sum=0,max=Integer.MIN_VALUE;
			int i=0;
			for(i=0;i<size;i++)
			{
				if(arr[i]>=0)
				{
					curr_sum+=arr[i];
					arr[i]=curr_sum;
				}
				else
				{
					arr[i]=Integer.MIN_VALUE;
					if(curr_sum>max)
					{

						max=curr_sum;
						//    	start=end+1;

					}
					curr_sum=0;
				}
			}

			if(curr_sum>max)
			{

				max=curr_sum;
				arr[i-1]=max;

			}
			i=i-1;
			while(arr[i]!=max)
			{
				i--;
			}
			if(max==0)
				System.out.println(arr[i]);
			else
			{
				String s="";

				for(int j=i;j>=0;j--)
				{
					if(j-1>=0 &&arr[j-1]!=Integer.MIN_VALUE)
					{
						int val= arr[j]-arr[j-1];
						s=val+" "+s;
					}
					else
					{
						s=arr[j]+" "+s;
						break;
					}


				}
				System.out.println(s);
			}

			test--;
		}


	}

		static String repeatingNum(int arr[],int size)
		{
				
			Arrays.sort(arr);
			int count=1,j=0;
			int min=1,repeat=Integer.MIN_VALUE;
			min = arr[0]!=1?1:Integer.MIN_VALUE;
			for(int i=0;i<size-1;i++)
			{
				j=i+1;
				if(arr[i]!=arr[j])
				{
					if(arr[i]!=count && min==Integer.MIN_VALUE) 
						min=count;
					count++;
						
						
				}
				else  if(min==Integer.MIN_VALUE || repeat==Integer.MIN_VALUE) 
						repeat=arr[i];
				else
					break;
			}
			if(min==Integer.MIN_VALUE)
				min=count;
			if(repeat==arr[size-1])
				min=count+1;
			return repeat+" "+min;
		}
		
		static void find(int arr[],int size)
		{

		    int min=Integer.MAX_VALUE;
		    for(int i=0;i<size;i++)
		    {
		        if(arr[Math.abs(arr[i])-1]>0)
		        {
		            arr[Math.abs(arr[i])-1]= -arr[Math.abs(arr[i])-1];
		        }
		        else
		        {
		            int a=Math.abs(arr[i]);
		            if(a<min)
		            min=a;
		        }
		    }
		    System.out.print(min+" ");
		    for(int i=0;i<size;i++)
		    {
		        if(arr[i]>0){
		        System.out.print(i+1+"\n");
		        break;
		        }
		    }

		}
}
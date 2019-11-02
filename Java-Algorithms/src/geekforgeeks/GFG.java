package geekforgeeks;
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		//code
		BufferedReader buf = new BufferedReader (new InputStreamReader(System.in));
		int test =  Integer.parseInt(buf.readLine());
	
		
		while(test>0)
		{
		    int size = Integer.parseInt(buf.readLine());
		    String sizearr = buf.readLine();
		    String str[] = new String[size];
		    str = sizearr.split(" ");
		    
		    boolean flag=false;
		    for(int i=0;i<size;i++)
		    {
		    	
		    	if(Integer.parseInt(str[i])==-1)
		    	{
		    		flag = true;
					System.out.println(1);
					break;		
		    	}
		    		
		        if(Integer.parseInt(str[i]) <size)
			{
				if(str[Integer.parseInt(str[i])]=="-1")
					{flag = true;
				System.out.println(1);
				break;			
					}
				else
				{
					str[i]="-1";
				}
			     
			}
			   
		    }
		    if(!flag)
		    System.out.println(0);
		    
		    test--;
		}
	}
	
	static void  PrintarrElements(String str[],String str2[],int size1,int size2)
	{
		int i=0,j=0;
		StringBuilder sb = new StringBuilder();
		
		
		for(i=0;i<size1;i++)
		{
			if(str[Integer.parseInt(str[i])]=="-1")
			{
				System.out.println(1);
				break;
			}
			else
			{
				str[i]="-1";
			}
	        
	        
	            
	    }
		
		while(i<size1 && j<size2)
		{
			
			sb.append(str[i++]);
			sb.append(" ");
			sb.append(str2[j++]);
			sb.append(" ");
			/*System.out.print(str[i++]+" ");
			System.out.print(str2[j++]+" ");*/
		}
		
		while(i<size1)
		{
			sb.append(str[i++]);
			sb.append(" ");
			//System.out.print(str[i++]+" ");
			//System.out.print(str[j++]+" ");
		}
		
		while(j<size2)
		{
			sb.append(str2[j++]);
			sb.append(" ");
			//System.out.print(str2[j++]+" ");
		}
		
		System.out.println(sb);
	}
}
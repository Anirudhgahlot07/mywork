package com.java.All_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class All_recursion_problems {
	
	static String codes[] = {"+", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz", "*", "#"};

	public static void main(String[] args) throws Exception{
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i=2;*/
		// TODO Auto-generated method stub
		solve("abc", "", 0);
		//System.out.println(subsequence("ani", ""));
		//System.out.println(permuatationOfString("aaa", ""));
		//System.out.println(keyPadProblems("235", ""));
		//System.out.println(mazePath_no_diagnal(0, 0, 2, 2, ""));
		//System.out.println(mazePath_with_diagonal(0, 0, 2, 2, ""));
		//System.out.println(mazePath_with_multiStep(0, 0, 2, 2, ""));
		//System.out.println(BoardPath(0, 10, ""));
		//System.out.println(mazePath_no_diagnal_returnArrayList(0, 0, 2, 2, "", new ArrayList<String>()));
		//System.out.println(reverseNum(145));
		//System.out.println(Gcd(52, 11));
		//printNthFibonnaci_02(55);
		//System.out.println(deleteHi("ihihhhahihahah",0,0,new StringBuilder()));
		//System.out.println(deleteHi_01("hihhhahihahah",0,0,""));
		//System.out.println(countHi("hihhhahihahah", 0, 0, 0));
		//printNthFibonnaci_02(2);
		//System.out.println(printAllPermutation("abc", ""));
		/*
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		validParenthesis(br.readLine());*/
		//System.out.println(validParenthesis("[a+{b+(c(d)+e}+f]"));
		//printAllPossibleCodes("11223344", "");
		//printAllPossibleCodes("1461997", "");
		//daysinMonth("28 mon");
		//daysinMonth("31 wed");
		//String str = "a";
		//System.out.println(str.substring(1,str.length()-1));
		
		int arr1[] ={7,9,2};
		subSet(arr1, arr1.length-1, "");
		//print_pattern();
		//callQueen();
		int arr[]={-2, -5, 6, -2, -3, 1, 5, -6};
		System.out.println(MaxsubArray(arr));
		//int arr1[][]={{0,1},{0,2},{1,3},{0,4},{0,5}};
		//System.out.println(isSame(arr1, 5, 2, 0));
	}
	
	static void callQueen()
	{
		boolean arr[][] = new boolean[4][4];
		//System.out.println(PlaceQueen_2D(arr, 0, 1, 4, ""));
		System.out.println(PlaceQueen_2D_sub_seq(arr, 0, 1, 4, ""));
	}
	
	static void print_pattern()
	{
		printPattern_10(4);
	}
	
	
	 static  boolean  isPrime(int n)
	    {
	       for(int i=2;i*i<=n;i++)
	       {
	           if(n%i==0)
	               return false;
	       }
	        return true;
	    }
	
	 	static int reverseNum(int n)
	 	{
	 		int temp=0;
	 		while(n>0)
	 		{
	 			int dig = n%10;
	 			int num = n/10;
	 			temp = temp*10+dig;
	 			n=num;
	 			
	 		}
	 		return temp;
	 	}
	 
	 	
	 	static int Gcd(int num1,int num2)
	 	{
	 		
	 		if(num1%num2==0)
	 			return num2;
	 		
	 		return Gcd(num2%num1,num1);
	 			
	 	}
	public static int subsequence(String str,String ans)
	{
		if(str.length()==0)
		{
			System.out.print(ans+" ");;
			return 1;
			
		}
		
		
		int count=0;
		char ch = str.charAt(0);
		String rem = str.substring(1);
		count+=subsequence(rem, ans+ch);
		count+=subsequence(rem, ans);
		return count;
	}
	
	public static int printAllPermutation(String str,String ans)
	{
		if(str.length()==0)
		{
			System.out.println(ans);
			return 1;
		}
		
		
		int count=0;
		int isset=0;
		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			int mask=1<<(ch-'a');
			if((isset&mask)==0)
			{
			String first=str.substring(0,i);
			String after = str.substring(i+1);
			count+=printAllPermutation(first+after, ans+ch);
			isset |= mask; 
			}
		}
		
		return count;
	}
	
	public static int printNthFibonnaci(int n)
	{
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return (printNthFibonnaci(n-2)+printNthFibonnaci(n-1));
	}
	
	
	
	public static StringBuilder deleteHi(String s, int index, int val, StringBuilder sb)
    {
        if(index>=s.length())
        {
            return sb;
        }
        else{
            if(s.charAt(index)=='h')
            {
                val=1;
                sb.append('h');
                return deleteHi(s,index+1,val,sb);
            }
            else if(s.charAt(index)=='i' && val==1)
            {
                val=0;
                sb=new StringBuilder(sb.substring(0,sb.length()-1));
                return deleteHi(s,index+1,val,sb);
            }
            else
            {
                val=0;
                sb.append(s.charAt(index));
                return deleteHi(s,index+1,val,sb);
            }
        }
    }
	
	
	public static String deleteHi_01(String s, int index, int val, String sb)
    {
        if(index>=s.length())
        {
            return sb;
        }
        else{
            if(s.charAt(index)=='h')
            {
                val=1;
                sb=sb+'h';
                return deleteHi_01(s,index+1,val,sb);
            }
            else if(s.charAt(index)=='i' && val==1)
            {
                val=0;
                sb=new String(sb.substring(0,sb.length()-1));
                return deleteHi_01(s,index+1,val,sb);
            }
            else
            {
                val=0;
                sb+=(s.charAt(index));
                return deleteHi_01(s,index+1,val,sb);
            }
        }
    }
	
	
	
	public static int countHi(String str,int count,int index,int val)
	{
		if(index==str.length())
			return count;
		else if(str.charAt(index)=='h')
		{
			val=1;
			count=countHi(str, count, index+1, val);
		}
		else if(str.charAt(index)=='i' && val==1)
		{
			val=0;
			count=countHi(str, count+1, index+1, val);
		}
		else
			count=countHi(str, count, index+1, val);
		return count;
	}
	
	 public static void printNthFibonnaci_02(int n)
	    {
	        int a=0,b=1;int sum=0;
	        for(int i=0;;i++)
	        {

	             if(a<=n)
	            {
	                
	                
	                System.out.print(a+" ");
	                sum = a+b;
	                a=b;
	                b=sum;
	                
	            }
	             else
	            	 break;
	                
	        }
	    }
	 
	public static int permuatationOfString(String str,String ans)
	{
		if(str.length()==0)
		{

			System.out.print(ans+" ");
			return 1;
			
		}
		
		int count=0;
		int isSet=0;
		
		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			int mask =1<<(ch-'a');
			if((isSet&mask)==0)
			{
			String first = str.substring(0,i);
			String rem=str.substring(i+1);
			isSet |=mask;
			count+=permuatationOfString(first+rem, ans+ch);

			
			}
		}
		
		return count;
	}
	
	public static int keyPadProblems(String keyPressed,String ans)
	{
		
			if(keyPressed.length()==0)
			{
				System.out.println(ans);
				return 1;
			}
			
			char ch = keyPressed.charAt(0);
			String word = codes[ch-'0'];
			String rem = keyPressed.substring(1); 
			
			int count=0;
			for(int i=0;i<word.length();i++)
			{
				
				count+=keyPadProblems(rem, ans+word.charAt(i));
			}
			
			return count;
		
	}
	
	public static int mazePath_no_diagnal(int srcRow,int srcCol,int endrow,int colEnd,String ans)
	{
		if(srcRow==endrow && srcCol ==colEnd)
		{
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		
		if(srcRow+1<=endrow)
		{
			count+=mazePath_no_diagnal(srcRow+1, srcCol, endrow, colEnd, ans+"V");
			
		}
		if(srcCol+1<=colEnd)
		{
			count+=mazePath_no_diagnal(srcRow, srcCol+1, endrow, colEnd, ans+"H");
		}
		
		return count;
	}
	
	public static ArrayList<String> mazePath_no_diagnal_returnArrayList(int srcRow,int srcCol,int endrow,int colEnd,String ans,ArrayList<String> outlist)
	{
		if(srcRow==endrow && srcCol ==colEnd)
		{
			
			outlist.add(ans);
			return outlist;
		}
		
		
		ArrayList<String> list=null;
		if(srcRow+1<=endrow)
		{
			
			list=mazePath_no_diagnal_returnArrayList(srcRow+1, srcCol, endrow, colEnd, ans+"V",outlist);
			
		}
		if(srcCol+1<=colEnd)
		{	
			
			list=mazePath_no_diagnal_returnArrayList(srcRow, srcCol+1, endrow, colEnd, ans+"H",outlist);
			
		}
		
		return list;
	}
	
	
	public static int mazePath_with_diagonal(int srcRow,int srcCol,int endrow,int colEnd,String ans,ArrayList<String> list)
	{
		if(srcRow==endrow && srcCol ==colEnd)
		{
			list.add(ans);
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		
		if(srcRow+1<=endrow)
		{
			count+=mazePath_with_diagonal(srcRow+1, srcCol, endrow, colEnd, ans+"V",list);
			
		}
		if(srcCol+1<=colEnd)
		{
			count+=mazePath_with_diagonal(srcRow, srcCol+1, endrow, colEnd, ans+"H",list);
		}
		
		if(srcCol+1<=colEnd  && srcRow+1<=endrow)
		{
			count+=mazePath_with_diagonal(srcRow+1, srcCol+1, endrow, colEnd, ans+"D",list);
		}
		
		
		return count;
	}
	
	public static int mazePath_with_multiStep(int srcRow,int srcCol,int endrow,int colEnd,String ans)
	{
		if(srcRow==endrow && srcCol ==colEnd)
		{
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		
		for(int i=1;srcRow+i<=endrow;i++)
		{
			count+=mazePath_with_multiStep(srcRow+i, srcCol, endrow, colEnd, ans+"V"+i);
			
		}
		for(int i=1;srcCol+i<=colEnd;i++)
		{
			count+=mazePath_with_multiStep(srcRow, srcCol+i, endrow, colEnd, ans+"H"+i);
		}
		
		/*
		if(srcCol+1<=colEnd  && srcRow+1<=endrow)
		{
			count+=mazePath_with_multiStep(srcRow+1, srcCol+1, endrow, colEnd, ans+"D");
		}
		*/
		
		return count;
	}
	
	public static int BoardPath(int src,int dest,String ans)
	{
		
		if(src==dest)
		{
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		for(int dice=1;dice+src<=dest&&dice<=6;dice++)
		{
			count+=BoardPath(dice+src, dest, ans+src+"dice :"+dice+" ");
		}
		
		return count;
		
	}
	
	public static int PlaceQueen(int arr[],int idx,int qpsf,int total,String ans)
	{
		if(qpsf==total+1)
		{
			System.out.println(ans);
			return 1;
		}
			
		
		int count=0;
		for(int i=idx;i<arr.length;i++)
		{
			count+=PlaceQueen(arr, i+1, qpsf+1, total, ans+"q"+qpsf+"b"+i+" ");
		}
		return count;
	}
	
	public static int PlaceQueen_2D(boolean arr[][],int idx,int qpsf,int total,String ans)
	{
		if(qpsf==total+1)
		{
			System.out.println(ans);
			return 1;
		}
		int row =arr.length;
		int col = arr[0].length;
		
		int count=0;
		for(int i=idx;i<row*col;i++)
		{
			int r = i/col;
			int c = i%col;
			if(isQueenSafe(arr, r, c))
			{
			arr[r][c]=true;
			count+=PlaceQueen_2D(arr, i+1, qpsf+1, total, ans+"q"+qpsf+"b("+r+","+c+") ");
			arr[r][c]=false;
			}
		}
		return count;
	}
	
	public static int PlaceQueen_2D_sub_seq(boolean arr[][],int idx,int qpsf,int total,String ans)
	{
		int row =arr.length;
		int col = arr[0].length;
		if(qpsf==total+1 || idx>=row*col)
		{
			if(qpsf==total+1)
			{
			System.out.println(ans);
			return 1;
			}
			return 0;
		}
		
		
		int count=0;
		
			int r = idx/col;
			int c = idx%col;
			
			if(isQueenSafe(arr, r, c))
			{
			arr[r][c]=true;
			count+=PlaceQueen_2D_sub_seq(arr, idx+1, qpsf+1, total, ans+"q"+qpsf+"b("+r+","+c+") ");
			
			
			arr[r][c]=false;
			
			}
			
			count+=PlaceQueen_2D_sub_seq(arr, idx+1, qpsf, total, ans);
			
			
		return count;
	}
	
	public static boolean  isValidSpot(int x,int y,int rows,int cols)
	{
		if(x<0 || y<0 || x>=rows|| y>=cols)
			return false;	
		return true;
	}
	public static boolean isQueenSafe(boolean arr[][],int x,int y)
	{
		
		int rows = arr.length;
		int cols = arr[0].length;
		int dir[][]={{-1,0},{0,-1},{-1,-1},{-1,1}
		};
		
		for(int i=0;i<dir.length;i++)
		{
			for(int rad=1;rad<rows;rad++)
			{
				int r = x+rad *dir[i][0];
				int c = y+ rad* dir[i][1];
				if(isValidSpot(r, c, rows, cols) && arr[r][c])
					return false;
			}
		}
		
		
		return true;
	}
	
	public static boolean isQueenSafe_trial(boolean arr[][],int x,int y)
	{
		int len = arr.length;
		int col = arr[0].length;
		
		int dir[][]={{-1,0},{0,-1},{-1,1},{-1,-1}};
		
		for(int i=0;i<4;i++)
		{
			for(int rad=1;rad<=Math.max(len, col);rad++)
			{
				int r = x+rad*dir[i][0];
				int c = y+rad*dir[i][1];
				if(isValidSpot(r, c, len, col) && arr[r][c])
					return  false;
			}
		}
		
		return true;
		
	}
	
	public static void printPattern_10(int n)
	{

        int space =n-1;int num=1;
        for(int i=num;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
            	
                
                if(j!=1)
                System.out.print(" "+j);
                else
                	System.out.print(j);
            }
            for(int j=space;j>=i;j--)
            {
                System.out.print("  ");
            }
            
            for(int j=space;j>i;j--)
            {
                System.out.print("  ");
            }
            
            
            for(int j=i;j>=1;j--)
            {
                if(j!=n) 
                System.out.print(" "+j);
               
              
                    
            }
            System.out.println();
        }
	}
	
	
	public static boolean validParenthesis(String str)
	{
		if(str.length()<1)
			return true;
		
		if(str.length()>1)
		{
		if(str.charAt(0)=='[' )
			{	if(str.charAt(str.length()-1)==']')
				return validParenthesis(str.substring(1,str.length()-1));
			else
				return false;
			}
			if(str.charAt(0)=='{')
				{ if(str.charAt(str.length()-1)=='}')
				return validParenthesis(str.substring(1,str.length()-1));
				else return false;
				}
				
				if(str.charAt(0)=='(')
					{ if(str.charAt(str.length()-1)==')')
					return validParenthesis(str.substring(1,str.length()-1));
					else return false;
					}
				else 
					return validParenthesis(str.substring(1,str.length()-1));
		}
		else
			if(str.charAt(0)=='[' || str.charAt(0)=='{' || str.charAt(0)=='(' || str.charAt(0)==']' ||
					str.charAt(0)=='}' || str.charAt(0)=='}')
				return false;
			return true;
	}
	
	
	public static void printAllPossibleCodes(String str,String ans)
    {
        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }
        
        String sb = str.substring(0,1);
        int k  = Integer.parseInt(sb); 
        if(k!=0)
        {
        char a= (char)(k+'a'-1);
        printAllPossibleCodes(str.substring(1), ans+(a+""));
        }
        //else    printAllPossibleCodes(str.substring(1),ans);
        
        if(str.length()>=2)
        {
            sb = str.substring(0,2);
            int i = Integer.parseInt(sb);
            if(i<=26 && i>0 )
            {
            char  a= (char)(i+'a'-1);
            printAllPossibleCodes(str.substring(2), ans+(a+""));
            }
            //else printAllPossibleCodes(str.substring(2), ans);
        }
             
        }
	
	public static void daysinMonth(String str)
	{
		
		int days = Integer.parseInt(str.split(" ")[0]);
		String day = str.split(" ")[1];
		String week[]={"mon","tues","wed","thurs","fri","sat","sun"};
		int day_num=0;
		String ans="";
		String ans2="";
		for(int i=0;i<7;i++)
		{
			if(week[i].equals(day))
			{
				day_num=i+1;
				break;
			}
		}
		
		int i=0;
		for(i=day_num;i<=7;i++)
		{
			int count = NoOfDays(days,i-day_num+1);
			ans+=count+" ";
		}
		i=8-day_num;
		for(int j=1;j<day_num;j++)
		{
			int count = NoOfDays(days,j+i);
			ans2+=count+" ";
			
		}
		ans = ans2+ans;
		System.out.println(ans);
	}
	
	public static int NoOfDays(int days,int day_num)
	{
		if(days-day_num<7)
			return 1;
		int count=0;
		
		count = NoOfDays(days, day_num+7)+1;
		return count;
	}
	
	  public static int MaxsubArray(int arr[])
	    {
	        int sum=arr[0];
	        int maxSum=0;
	        for(int i=1;i<arr.length;i++)
	        {
	            if(arr[i]+sum>=arr[i])
	                sum+=arr[i];
	            else
	                sum=arr[i];
	            maxSum = Math.max(sum, maxSum);
	        }
	        
	        return maxSum;
	    }
	  
	  public static boolean isSame(int arr[][],int rows,int cols,int idx)
      {
          
          boolean vertical=true,horiz=true;
          
          for(int i=1;i<rows;i++)
          {
              if(vertical && (arr[i-1][0]!=arr[i][0]))
              {
                  vertical = false;
                  
              }
              
              if(horiz && (arr[i-1][1]!=arr[i][1]))
              {
                  horiz = false;
                  
              }
              
          }
          
          if(vertical || horiz)
              return true;
          else
              return false;
          
          
      }
	  
	  public static void subSet(int arr[],int idx,String ans)
	  {
		  if(idx>=-1)
		  {
			  
			  if(idx==-1)
			  {
				  System.out.println("["+ans+"]");
				  return;
			  }
			  
		  }
		  
		  //for(int i=idx;i<arr.length;i++)
		  {
			  subSet(arr, idx-1, ans);
			  subSet(arr, idx-1, arr[idx]+" "+ans);
			
		  }
	  }
	  
	  public static void solve(String s,String ans,int idx)
	    {
	     if(s.length()==0)
	     {
	         System.out.println(ans);
	         return;
	     }
	       
	        int len = s.length();
	        for(int i=0;i<len;i++)
	        {
	            char ch = s.charAt(i);
	            String first = s.substring(0,i);
	            String after = s.substring(i+1);
	            solve(first+after,ans+ch,i+1);
	        }
	        
	        
	    }
	
}


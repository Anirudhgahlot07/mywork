package com.java.sep15;

public class ClassSep15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(3&1);
		//int arr[] ={1,1,2,2,3,3,4,4,5};
		int arr[] ={3,3,4,5,5};
		System.out.println(tellMissingPair(arr, 0, arr.length-1));
	}


	public static int tellMissingPair(int arr[],int begin,int last)
	{
		int index;
		if(begin==last)
			return arr[begin];
		
			int mid=(begin+last)/2;
			
			if((mid&1)==1)
			{
				if(arr[mid]==arr[mid-1]) // odd case
					index= tellMissingPair(arr, mid+1, last);
				else
					index= tellMissingPair(arr, begin, mid-1);
			}
			else
			{
				if(arr[mid]==arr[mid+1]) // even case
					 index = tellMissingPair(arr, mid+2, last);
					
					else
						 index = tellMissingPair(arr, begin, mid);
				
			}
			
			return index;
			
		
		
	}
}

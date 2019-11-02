package com.java.sep28;

public class classSep28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={10,20,30,40,50,60,70};
		System.out.println(equiset(arr, 1, 10, 0, "", ""));

	}
	
	
	public void traverseFloodFillAlgoPrac(int rowstart,int colstart,int rowend,int colend,String ans)
	{
		
		if(rowstart==rowend && colstart==colend)
		{
			
			System.out.println(ans);
			return ;
		}
		
		if(rowstart+1<=rowend)
		{
			
		}
		
		if(colstart+1<=colend)
		{
			
		}
		if(rowstart>0)
		{
			
		}
		if(colstart>0)
		{
			
			
			
		}
	}
	
	
	public static int equiset(int arr[],int index,int set1,int set2,String ans1,String ans2)
	{
		if(index==arr.length)
		{
			if(set1==set2)
			{
				System.out.println(ans1+"="+ans2);
				return 1;
			}
			return 0;
		}
		
		int count=0;
		count+=equiset(arr, index+1, set1+arr[index], set2, ans1+arr[index]+" ", ans2);
		count+=equiset(arr, index+1, set1, set2+arr[index], ans1, ans2+arr[index]+" ");
		return count;
	}

}

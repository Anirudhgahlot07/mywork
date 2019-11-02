package com.java.Sep14;

public class ClassSep14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printTree(5));
	}
	
	static 	int printTree(int n)
	{
		if(n==1|| n==0)
			return n;
		
		int ans=0;
		System.out.println("pre :"+n);
		ans+=printTree(n-1);
		
		System.out.println("In :"+n);
		ans+=printTree(n-2);
		System.out.println("post :"+n);
		
		return ans+3;
		
		
	}

}

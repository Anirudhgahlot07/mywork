package com.java.Oct13;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[]={10,20,-1,30,40,-1,-1,50,70,-1,-1,-1,90,80,-1,-1,100};
		int[] arr={10,20,40,80,-1,-1,90,-1,-1,50,100,-1,-1,-1,30,60,-1,110,-1,-1,70,120,-1,-1,-1};
		BTTree bt = new BTTree(arr);
		bt.display();
		bt.Height();

	}

}

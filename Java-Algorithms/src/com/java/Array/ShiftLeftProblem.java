package com.java.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ShiftLeftProblem {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int arr []={1,2,3,4,5};
		
		arr =rotLeft(arr, 5);
		for(int  a : arr)
		{
			System.out.println(a);
		}
	}
	
	 static int[] rotLeft(int[] a, int d) {
	        int arr[]= a;
	        int len = arr.length;
	        int temp = 0, curr = 0;
	        int rot =d>=len?d%len:d;
	        if (rot==0)
	        return a;
	        else
	        for(int k =1;k<=rot;k++)
	        {
	            for (int i = len - 1; i > 0; i--) {

	                if (i == len - 1) {
	                    temp = arr[i - 1];
	                    arr[i - 1] = arr[i];
	                } else {
	                    curr = arr[i - 1];
	                    arr[i - 1] = temp;
	                    temp = curr;
	                }

	            }
	            arr[len - 1] = temp;
	      
	        }

	        return arr;

	    }

	   }

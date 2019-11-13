package com.java.Oct13;

import java.io.ObjectInputStream.GetField;
import java.util.Collections;

import com.java.Oct13.BST.Node;

//import com.java.Oct13.BST.Node;

public class AVL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve();
	}
	
	static void solve()
	{
		//int arr[]={10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
		int arr[] ={100,90,70,600,500,40,30,100,101,102,103,104,105};
		Node node = construct(arr, 0, arr.length-1);
		display(node);
		//node = updateCurrentNodeFactor(node);
		System.out.println(node.height);
		System.out.println("------------avl here----------");
		display(node);
		
		
		
	}
	
	static class Node
	{
		Node left;
		Node right;
		int data;
		int height=-1;
		int balance;
		int freq ;
		
		Node(int data)
		{
			this.data = data;
			this.freq=0;
		}
		
		Node(int data,Node left,Node right,int height,int balance)
		{
			this.data = data;
			this.left = left;
			this.right= right;
			this.height = height;
			this.balance=balance;
		}
	}
	
	static int getHeight(Node node)
	{
		if(node==null)
			return -1;
		int lh=-1;
		int rh=-1;
		if(node.left!=null)
			lh = node.left.height;
		if(node.right!=null)
			rh = node.right.height;
		return Math.max(lh, rh)+1;
		
	}
	
	/* balance factor > 1 - either (ll , lr)
	 	bf > 0 - ll
	 	bf < 0 - lr 
	 */
	
	
	/*
	   z
	    \
	     y
	    / \ 
	       x
	      / \	
	 */
	static Node leftRotation(Node node)
	{
		Node temp = node.right;
		Node a = temp.left;
		temp.left = node;
		node.right = a;
		updateFactors(node);
		updateFactors(temp);
		return temp;
	}
	
	/* 
	 		z
	     /   \
	   	y1
	  	/\
	   x  ..
	 /  \
	 */
	static Node rightRotation(Node node)
	{
		Node temp = node.left;
		Node a = temp.right;
		temp.right = node;
		node.left = a;
		updateFactors(node);
		updateFactors(temp);
		return temp;
	}
	
	static int getBalance(Node node)
	{
		if(node==null)
			return 0;
		int lh=-1;
		int rh=-1;
		if(node.left!=null)
			lh = node.left.height;
		if(node.right!=null)
			rh = node.right.height;
		return lh-rh;
		
	}
	
	
	static void updateFactors(Node node)
	{
		node.height = getHeight(node);
		node.balance = getBalance(node);
	}
	static void display(Node root)
	{
		if(root==null)
			return ;
		String s="";
		s+=root.left!=null?root.left.data:"";
		s+="==>"+root.data+"<==";
		s+=root.right!=null?root.right.data:"";
		System.out.println(s+"balanc is :"+root.balance);
		display(root.left);
		display(root.right);
	
	}
	static Node construct(int arr[],int start,int end)
	{
		if(start>end)
			return null;
		int mid = (start+end)/2;
		Node node = new Node(arr[mid]);
		
		node.left = construct(arr,start,mid-1);
		node.right = construct(arr,mid+1,end);
		updateFactors(node);
			
		return node;
	}
	
	static Node updateCurrentNodeFactor(Node node)
	{
		if(getBalance(node)>1)  // ll ,lr  --- BASICALLY WE HAVE A LONG LEFT TREE , WE HAVE A POSITIVE BALANCE IN CASE OF LEFT
		{
			if(getBalance(node.left)>0) // ll
				node = rightRotation(node);
			else
			{
				node.left = leftRotation(node.left);
				node = rightRotation(node);
			}
		}
		else if(getBalance(node)<-1) // rr,rl  -- BASICALLY WE HAVE A LONG RIGHT TREE
		{
			if(getBalance(node.right)<0) // rr
				node = leftRotation(node);
			else
			{
				node.right = rightRotation(node.right);
				node = leftRotation(node);
			}
		}
		
		return node;
	}
	
	static Node addNode(Node node,int data)
	{
		if(node==null)
			return new Node(data);
		if(node.data == data)
			node.freq++;
		if(node.data<data)
			node.right = addNode(node, data);
		else
			node.left = addNode(node, data);
			
		updateFactors(node);
		node = updateCurrentNodeFactor(node);
		
		return node;
	}
	
	public static int findMin(Node node)
	{
		if(node==null)
			return Integer.MAX_VALUE;
		return Math.min(findMin(node.left), node.data);
	}
	
	static Node deleteNode(Node node , int data)
	{
		if(node==null)
			return null;
		if(node.data<data)
			node.right = deleteNode(node, data);
		else if(node.data>data)
			node.left = deleteNode(node, data);
		else
		{
				if(node.left==null)
					return node.right;
				if(node.right==null)
					return node.left;
				node.data = findMin(node.right);
				node.right=deleteNode(node.right, node.data);
			
			
			
		}
		
		// updatefactors here
		updateFactors(node);
		node = updateCurrentNodeFactor(node);
		return node;
	}
}


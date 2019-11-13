package com.java.Oct13;

import javax.print.DocFlavor.INPUT_STREAM;

public class BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve();

	}

	static void solve()
	{
			int arr[]={10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
			Node root = constructBst(arr,0,arr.length-1);
			//System.out.println(findMax(root));
			//System.out.println(findMin(root));
			display(root);
			//System.out.println(max_iterative(root));
			//System.out.println(min_iterative(root));
			//System.out.println(height(root));
			//System.out.println(size(root));
			//System.out.println(find(root, 80));
			//System.out.println(LCA(root, 40, 90));
			pre_succ_01(root, 70);
			//System.out.println("pred is :: "+(pred!=null?pred.data:-1));
			//System.out.println("succ is :: "+succ!=null?succ.data:-1);
			System.out.println("---------new display-------------");
			//Node node = insertNode(root, 70);
			//Node  node = deleteIfLeaf(root, 20);
			Node  node = deleteAny(root, 60);
			System.out.println(size(root));
			
			
			display(node);
	}
	
	
	public static Node constructBst(int arr[],int start,int end)
	{
		if(start>end)
			return null;
		int mid = (start+end)/2;
		
		Node node = new Node(arr[mid]);
		node.left = constructBst(arr, start, mid-1);
		node.right=	constructBst(arr, mid+1, end);	
		
		
		return node;
	}
	static class Node
	{
		Node left;
		Node right;
		int data;
		
		Node(int data)
		{
			this.data = data;
		}
		
		Node(int data,Node left,Node right)
		{
			this.data = data;
			this.left = left;
			this.right= right;
		}
	}
	
	public static int findMax(Node node)
	{
		if(node==null)
			return -1;
		return Math.max(findMax(node.right), node.data);
	}
	
	public static int findMin(Node node)
	{
		if(node==null)
			return Integer.MAX_VALUE;
		return Math.min(findMin(node.left), node.data);
	}
	
	public static void display(Node node)
	{
		if(node==null)
			return ;
		String s="";
		s+=node.left!=null?node.left.data:"";
		s+=" ==> "+node.data+" <== ";
		s+=node.right!=null?node.right.data:"";
		System.out.println(s);
		display(node.left);
		display(node.right);
	}
	
	public static int max_iterative(Node node)
	{
		int max=Integer.MIN_VALUE;
		
		while(node!=null)
		{
			max=node.data;
			node=node.right;
		}
		
		return max;
	}
	public static int min_iterative(Node node)
	{
		int min=Integer.MAX_VALUE;
		
		while(node!=null)
		{
			min=node.data;
			node=node.left;
		}
		
		return min;
	}
	
	public static int height(Node node)
	{
		if(node==null)
			return 0;
		return Math.max(height(node.left),height(node.right))+1;
	}
	
	public static int size(Node node)
	{
		return node==null?0:size(node.left)+size(node.right)+1;
	}
	
	public static boolean find(Node node,int data)
	{
		if(node==null)
			return false;
		if(node.data==data)
		{
			System.out.println("data"+data);
			return true;
		}
		return find(node.left,data)|| find(node.right,data);
	}
	
	public static int LCA(Node node,int data1,int data2)
	{
		if(node==null)
			return -1;
		if(node.data<data1)
			return LCA(node.right, data1, data2);
		if(node.data>data2)
			return LCA(node.left, data1, data2);
		else
			return node.data;
	}	
	
	static Node pred=null;
	static Node succ=null;
	static Node pre = null;
	public static void pre_succ_01(Node node,int data)
	{
		if(node==null)
			return ;
		pre_succ_01(node.left,data);
		if(node.data==data)
			pred=pre;
		if(pre!=null && pre.data==data)
		{
			succ=node;
		}
		pre=node;
		
		pre_succ_01(node.right,data);
	}
	
	
	public static Node insertNode(Node node,int data)
	{
		if(node==null)
		{
			Node leaf = new Node(data);
			return leaf;
		}
		if(data<=node.data)
			node.left=insertNode(node.left, data);
		else if(data>node.data)
			node.right=insertNode(node.right, data);
		return node;
	}
	
	public static Node deleteIfLeaf(Node node,int data)
	{
		if(node==null)
		{
			return null;
		}
		if(node.data==data && node.left==null && node.right==null)
		{
			node=null;
			return node;
		}
		if(data<node.data)
			node.left=deleteIfLeaf(node.left, data);
		else if(data>node.data)
			node.right=deleteIfLeaf(node.right, data);
		return node;
	}
	
	public static Node deleteAny(Node node,int data)
	{
		if(node==null)
			return null;
		
	
		if(data<node.data)
			node.left=deleteAny(node.left, data);
		else if(data>node.data)
			node.right=deleteAny(node.right, data);
		else
		{
			if(node.left==null)
				return node.right;
			if(node.right==null)
				return node.left;
			node.data = findMin(node.right);
			node.right=deleteAny(node.right, node.data);
			
		}
		
		return node;
	}
}



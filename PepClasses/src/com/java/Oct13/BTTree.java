package com.java.Oct13;

public class BTTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	private  class Node
	{
		
		private int data;
		private Node left;
		private Node right;
		
		
		Node(int data)
		{
			this.data = data;
		}
		
		Node(int data,Node left,Node right)
		{
			this.data    = data;
			this.left 	 = left;
			this.right   = right;
			
		}
		
		
	}
	Node root=null;
	static int index=0;
	
	
	public Node construct(int arr[])
	{
		if(index>=arr.length || arr[index]==-1)
		{
			index++;
			return null;
		}

		Node node = new Node(arr[index],null,null);
		index++;
		node.left = construct(arr);
		node.right = construct(arr);
		return node;
	}
	
	public BTTree(int arr[])
	{
		root = construct(arr);
		
	}
	
	public void display()
	{
		display(this.root);
	}

	private void display(Node node)
	{
		if(node==null)
			return ;
		
		StringBuilder sb = new StringBuilder();
		sb.append(node.left!=null?node.left.data:".");
		sb.append("->"+node.data+"<-");
		sb.append(node.right!=null?node.right.data:".");
		System.out.println( sb.toString());
		
		
		display(node.left);
		display(node.right);
	}
	
	private int tellHeight(Node node)
	{
		if(node.left==null || node.right==null)
		{
			if(node.left==null)
				return 1;
			if(node.right==null)
				return 1;
		}
			
		
		int left = tellHeight(node.left)+1;
		int right = tellHeight(node.right)+1;
		
		return Math.max(left, right);
	}
	
	public void Height()
	{
		System.out.println(tellHeight(this.root));
	}
}

package dataStructures;

import java.time.chrono.MinguoChronology;
import java.util.Scanner;

public class Tree {

	static Node root;
	
	static class Node
	{
		int data;
		Node left;
		Node right;
	}
	
	public Node createNode (int data)
	{
		Node nd = new  Node();
		nd.data = data;
		nd.left  = nd.right = null;
		
		return nd;
	}
	
	
	public void traverseBst(Node node)
	{
		if(node!=null)
		{
			traverseBst(node.left);
			System.out.print(node.data+"\t");
			traverseBst(node.right);
		}
		else 	
			return;
			
	}
	
	public boolean findelement(Node node,int data)
	{
		boolean flag = false;
		if(node!=null && node.data==data)
		{
			flag =  true;
			return flag;
			
		}
		else
		{
				flag = false;
				
		}
		if(!flag &&  node!=null &&data<=node.data)
			flag =findelement(node.left, data);
		else	
			if(!flag && node!=null)
			flag =findelement(node.right, data);

		return flag;
	}
	
	
	public int findMax(Node node)
	{
		int max= -99 ;
		if(node.right!=null)
			max =findMax(node.right);
		else
			max=node.data;
		
		return max;
			
	}
	
	public int findMin(Node node)
	{
		int min = 9999999;
		if(node.left!=null)
			min = findMin(node.left);
		else
			min = node.data;
		
		return min;
	}
	
	public Node createBinaryTree(Node node ,int data)
	{
		if(node == null)
		{
			node = createNode(data);
			
		}
		
		else
		{
			if(data<=node.data)
			{
				node.left = createBinaryTree(node.left, data);
			}
			else
				node.right = createBinaryTree(node.right,data);
		}
		
		return node;
	}
	public static void main(String[] args) {
		
		Tree bst = new  Tree();
		
		System.out.println("enter size of array");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] =  new int[n];
		
		System.out.println("Enter elemets");
		for(int i =0 ; i<n ;i++)
		{
			arr[i]=sc.nextInt();	
		}
		
		Node curr=null,newnode=null;
		for(int i =0 ; i<n ;i++)
		{
			if(i==0)
			{
				root = bst.createBinaryTree(curr, arr[i]);
				curr=root;
			}
			else
			{
				newnode=bst.createBinaryTree(curr, arr[i]);
				//curr = newnode;
			}
		}
		
		bst.traverseBst(root);
		System.out.println(root.data);
		
		System.out.println("Max is :"+bst.findMax(root));
		
		System.out.println("Min is :"+bst.findMin(root));
		

		
		/*System.out.println("enter element to search");
		int num = sc.nextInt();
		System.out.println(bst.findelement(root, num)?"found":"not found");
		*/
		sc.close();
		
		
	

	}

}

package com.java.Oct13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	
	public static void main(String args[])
	{
		//int[] arr={10,20,40,80,-1,-1,90,-1,-1,50,100,-1,-1,-1,30,60,-1,110,-1,-1,70,120,-1,-1,-1};
		int[] arr1={50,30,10,-1,-1,40,-1,-1,60,55,-1,-1,70,-1,-1};
		
		//int[] arr={10,20,40,80,-1,-1,90,-1,-1};
		Node idx = new Node(0,null,null);
		//Node root = construct(arr, idx);
		Node root = construct(arr1, idx);
		
		traversals();
		
		/*
		levelOrder_01(root);
		
		System.out.println("--------------------------------");
		levelOrder_02(root);
		System.out.println("--------------------------------");
		levelOrder_03(root);
		System.out.println("--------------------------------");
		levelOrder_04(root);
		*/
		
		call(root);
		
		//ArrayList<Node> li =tellPath(root, 90);
			
		
	}
	
	static int cont=0;
	
	public static void call(Node root)
	{
		

		/*System.out.println(max(root));
		System.out.println(min(root));
		System.out.println(find(root, 120));
		*/
		
		ArrayList<Node> li = new ArrayList<>();
		
		
		/*System.out.println(rootToNodePath_01(root, 90, li));
		for(Node nd:li)
		{
			System.out.print(nd.data+"->");
		}
		System.out.println();
		System.out.println("02-----");
		System.out.println("root to node here");
		li = rootToNodePath_02(root, 60);
		System.out.println("count"+cont);
		for(Node nd:li)
		{
			System.out.print(nd.data+"->");
		}
		*/
		/*
		System.out.println("leaf nodes-------------------");
		leafNodes(root);
		
		display(root);
		System.out.println("preorder");
		preOrder(root);
		System.out.println("inorder");
		inOrder(root);
		System.out.println("postorder");
		postOrder(root);
*/	
		System.out.println();
		System.out.println("count was :"+cont);
		System.out.println(isBst_02(root));
		System.out.println("count is :"+cont);
		//System.out.println(lowestCommonAncs_01(50, 60, root));
		//System.out.println(lowestCommonAncs_02(50, 60, root));
		System.out.println(lowestCommonAncs_03(root, 40, 60).data);
		
		/*
		System.out.println("bst check here");
		System.out.println(isBST(root).countBst);
		System.out.println(isBst_01(root));
		
		*/
		
		System.out.println(deleteLeaf_01(root, 10).data);
		inOrder(root);
	}
	private  static class Node
	{
		
		private int data;
		private Node left;
		private Node right;
		//BSTInstance bst;
		
		
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
	
	public static Node construct(int arr[],Node idx)
	{
		if(idx.data==arr.length || arr[idx.data]==-1)
		{	
			idx.data++;
			return null;
		}
		
		Node node = new Node(arr[idx.data],null,null);
		idx.data++;
		node.left = construct(arr, idx);
		node.right = construct(arr, idx);
		
		return node;
		
	}
	
	public static void display(Node node){
        if(node==null) return;

        StringBuilder sb=new StringBuilder();

        sb.append(node.left!=null?node.left.data:".");
        sb.append(" -> " + node.data + " <- ");
        sb.append(node.right!=null?node.right.data:".");
         
        System.out.println(sb.toString());

        display(node.left);
        display(node.right);
    }
	

    //Util.=================================================

    public static int size(Node node){
      if(node==null) return 0;
      return size(node.left) + size(node.right) + 1;
    }


    public static int height(Node node){
     if(node==null) return 0;
     return Math.max(height(node.left),height(node.right))+1;
    }
    
    public static void preOrder(Node node)
    {
    	if(node==null)
    		return ;
    	else
    		System.out.print(node.data+"  ");
    	preOrder(node.left);
    	preOrder(node.right);
    }
    
    public static void inOrder(Node node)
    {
    	if(node==null)
    		return;
    	inOrder(node.left);
    	System.out.print(node.data+"  ");
    	inOrder(node.right);
    }
    
    public static void postOrder(Node node)
    {
    	if(node ==null)
    		return;
    	postOrder(node.left);
    	postOrder(node.right);
    	System.out.print(node.data+"  ");
    }
    
    public static int max(Node node)
    {
    	if(node==null)
    		return Integer.MIN_VALUE;
    	int left =Math.max(max(node.left),node.data);
    	int right =Math.max(max(node.right),node.data);
    	return Math.max(left, right);
    			
    	
    }
    
    public static int min(Node node)
    {
    	if(node==null)
    		return Integer.MAX_VALUE;
    	int left =Math.min(min(node.left),node.data);
    	int right =Math.min(min(node.right),node.data);
    	return Math.min(left, right);
    			
    	
    }
    
    public static boolean find(Node node,int data)
    {
    	if(node==null)
    		return false;
    	if(node!=null && node.data==data)
    		return true;
    	
    	return find(node.left,data)||find(node.right,data);
    	
    }
    public static Node findandReturnNode(Node node,int data)
    {
    	if(node==null)
    		return null;
    	if(node!=null && node.data==data)
    		return node;
    	
    	node.left =findandReturnNode(node.left,data);
    	node.right=findandReturnNode(node.right,data);
    	
    	return node;
    	
    }
    
    public static ArrayList<Node> tellPath(Node node,int data)
    {
    	if(node==null ||  node.data==data)
    	{
    		ArrayList<Node> li = new ArrayList<>();
    	if(node!=null &&node.data==data)
    	{
    		
    		li.add(node);
    		return li;
    		
    	}
    	return li;
    	}
    	
    	ArrayList<Node> list1=tellPath(node.left, data);
    	
    	ArrayList<Node> list2=tellPath(node.right, data);
    	ArrayList listout = new ArrayList<>();
    	for(Node nd:list1)
    	{
    		listout.add(nd);
    		
    	}
    	for(Node nd:list2)
    	{
    		listout.add(nd);
    		
    	}
    	
    	return listout;
    	
    	
    	
    }
    
    public static boolean rootToNodePath_01(Node root,int data,ArrayList<Node> path)
    {
    	if(root==null)
    		return false;
    	
    	
    	if(root.data==data)
    	{
    		path.add(root);
    		return true;
    	}
    	
    	
    	if(rootToNodePath_01(root.left, data, path))
    	{
    		path.add(root);
    		return true;
    	}
    	if(rootToNodePath_01(root.right, data, path))
    	{
    		path.add(root);
    		return true;
    	}
    	
    	return false;
    }
    
    
    public static ArrayList<Node> rootToNodePath_02(Node root,int data)
    {
    	//cont++;
    	if(root==null)
    	{
    		ArrayList<Node> li = new ArrayList();
    		return li;
    	}
    		
    	
    	if(root.data==data)
    	{

    		ArrayList<Node> li = new ArrayList();
    		li.add(root);
    		return li;
    	}
    	
    	ArrayList li = new ArrayList<>();
    	ArrayList<Node> left = rootToNodePath_02(root.left, data);
    	if(left.size()>0)
    	{
    		
    		li.add(root);
    		for(Node nd:left)
    		li.add(nd);
    	
    		return li;
    	}
    	
    	ArrayList<Node> right = rootToNodePath_02(root.right, data);
    	if(right.size()>0)
    	{
    		li.add(root);
    		for(Node nd:right)
    		li.add(nd);
    		
    		return li;
    	}
    	
    	return li;
    }
    
    public static void leafNodes(Node node)
    {
    	if(node==null)
    		return ;
    	if(node.left==null || node.right==null)
    	{
    		if(node.left==null && node.right==null)
    		{
    			System.out.print(node.data+" ");
    		}
    	}
    	
    	leafNodes(node.left);
    	leafNodes(node.right);
    		
    }
    
    public static void levelOrder_01(Node root)
    {
    	
    	Node node = root;
    	Queue<Node>  que = new LinkedList<Node>();
    	que.add(node);
    	
    	while(!que.isEmpty())
    	{
    		node = que.peek();
    		que.poll();
    		
    		if(node!=null)
    		{
    		System.out.print(node.data+" ");
    		
    		
    		if(node.left!=null)
    		{
    		que.add(node.left);
    		
    		}
    		if(node.right!=null)
    		{
    		que.add(node.right);
    	
    		}
    		}
    		
    	}

    }
    
    // line wise
    public static void levelOrder_02(Node root)
    {
    	Queue<Node> que1 = new LinkedList<Node>();
    	Queue<Node> que2 = new LinkedList<Node>();
    	que1.add(root);
    	
    	
    	while(!que1.isEmpty())
    	{
    		Node node = que1.peek();
    		que1.poll();
    		System.out.print(node.data+" ");
    		if(node.left!=null)
    			que2.add(node.left);
    		if(node.right!=null)
    			que2.add(node.right);
    		
    		if(que1.isEmpty())
    		{
    			System.out.println();
    			Queue<Node> q = que1;
    			que1 = que2;
    			que2 = q;
    		}
    	}
    }
    
    

    // line wise
    public static void levelOrder_03(Node root)
    {
    	Queue<Node> que1 = new LinkedList<Node>();
    	
    	que1.add(root);
    	
    	
    	while(!que1.isEmpty())
    	{
    		int size = que1.size();
    		while(size-->0)
    		{
    			Node node = que1.peek();
        		
        		que1.poll();
        		
    		System.out.print(node.data+" ");
    		if(node.left!=null)
    			que1.add(node.left);
    		if(node.right!=null)
    			que1.add(node.right);
    		}
    		
    		System.out.println();
    		
    		
    	}
    }
    
    public static void levelOrder_04(Node root)
    {
    	LinkedList<Node>  que1 = new LinkedList<Node>();
    	LinkedList<Node>  que2 = new LinkedList<Node>();
    	que1.add(root);
    	int count=0;
    	while(!que1.isEmpty())
    	{
    		
    		
    		
    			Node node = que1.removeFirst();
    			System.out.print(node.data+" ");
    			
    			if(count%2==0)
    			{
    			if(node.right!=null)
    				que2.addLast(node.right);

    			if(node.left!=null)
    				que2.addLast(node.left);
    			}
    			else
    			{
        			
        			if(node.left!=null)
        				que2.addLast(node.left);
        			if(node.right!=null)
        				que2.addLast(node.right);
        			
        			
    				
    			}
    			
    			if(que1.isEmpty())
    			{
    			
    			LinkedList<Node> temp = que1;
   				que1=que2;
   				que2=temp;
   				
   				Collections.reverse(que1);
   				
    			count++;
    			}
    		
    		
    		
    	}
    }
    
    public static int lowestCommonAncs_01(int data1,int data2,Node root )
    {
    	ArrayList<Node> li_1 = rootToNodePath_02(root, data1);
    	ArrayList<Node> li_2 = rootToNodePath_02(root, data2);
    	int size1 = li_1!=null?li_1.size():0;
    	int size2 = li_2!=null?li_2.size():0;
    	int curr=0;
    	for(int i=0,j=0;i<size1 && j<size2;i++,j++)
    	{
    		if(li_1.get(i).data==li_2.get(j).data)
    			curr = li_1.get(i).data;
    		else
    			break;
    	}
    	
    	return curr;
    }
    static Node Lca=null;
    public static boolean lowestCommonAncs_02(int data1,int data2,Node root)
    {
    	if(root==null)
    		return false;
    	
    	boolean selfDone = root.data == data1 || root.data==data2;
    	boolean leftDone = lowestCommonAncs_02(data1, data2, root.left);
    	if(Lca !=null)
    		return true;
    	boolean rightDone = lowestCommonAncs_02(data1, data2, root.right);
    	
    	if(leftDone && rightDone || (leftDone && selfDone) ||(rightDone && selfDone))
    		Lca = root;
    	return leftDone || rightDone || selfDone;
    }
    
    static boolean vi=false,v2=false;
    public static Node lowestCommonAncs_03(Node node,int data1,int data2)
    {
    	if(node==null)
    		return null;
    	
    	Node temp =null;
    	if(node.data == data1)
    	{
    		vi=true;
    		temp = node;
    	}
    	
    	if(node.data == data2)
    	{
    		vi=true;
    		temp = node;
    	}
    	
    	Node left_lca = lowestCommonAncs_03(node.left, data1, data2);
    	Node right_lca = lowestCommonAncs_03(node.right, data1, data2);
    	
    	if(temp!=null)
    		return temp;
    	
    	if(left_lca!=null && right_lca!=null)
    		return node;
    	
    	return left_lca!=null ? left_lca :right_lca;
    	
    }
    
    static class BSTInstance
    {
    	int min;
    	int max;
    	boolean isBst;
    	int countBst;
    	
    	public BSTInstance() {
			// TODO Auto-generated constructor stub
    		this.max = Integer.MIN_VALUE;
    		this.min = Integer.MAX_VALUE;
    		this.isBst = true;
    		this.countBst = 0;
    		
		}
    }
    
    
   
    static class diaPair{
    	int height=0;
    	int dia=0;
    	
    	public diaPair() {
    		this.height=0;
    		this.dia=0;
		}
    }
    	
    
    
    
    public static BSTInstance isBST(Node root)
    {
    	if(root==null)
    		return new BSTInstance();
    	
    	
    	
    	BSTInstance bsti_left = isBST(root.left);
    	BSTInstance bsti_right = isBST(root.right);
    	
    	BSTInstance curr = new BSTInstance();
    	curr.isBst=false;
    	if(bsti_left.isBst && bsti_right.isBst && root.data>=bsti_left.max  && root.data<=bsti_right.min)
    	{
    		curr.isBst = true;
    		curr.countBst = bsti_left.countBst+bsti_right.countBst+1;
    		
    	}
    	
    	curr.max= Math.max(root.data, Math.max(bsti_left.max,bsti_right.max));
		curr.min = Math.min(root.data, Math.min(bsti_left.min, bsti_right.min));
    	
    	
    
    	return curr;
    }
    
    static int prev = Integer.MIN_VALUE;
    public static boolean isBst_01(Node node)
    {
    	if(node==null)
    		return true;
    
    	boolean left = isBst_01(node.left);
    	if(!left){
    		return false;
    	}
    	
    	if(prev < node.data){
    		prev = node.data;
    	}else{
    		return false;
    	}
    	
    	boolean right = isBst_01(node.right);
    	
    	if(!right){
    		return false;
    	}
    	
    	return true;
    
    }
    
    public static boolean isBst_02(Node node)
    {
    	cont++;
    	if(node==null || (node.left==null && node.right==null))
    		return true;
    	
    	boolean left=false,right=false;
    	if(node.left!=null)
    	{
    		if(node.data>=node.left.data)
    		{
    			left= isBst_02(node.left);
    			
    		}
    	}
    	
    	if(node.right!=null)
    	{
    		if(node.data<=node.right.data)
    		{
    			right= isBst_02(node.right);
    			
    		}
    	}
    	
    	/*if(node.left!=null && node.right!=null)
    	{
    		if(node.data>=node.left.data && node.data<=node.right.data)
    		{
    				
    			return isBst_02(node.left) && isBst_02(node.right);
    			
    		}
    	}*/
    	return left&&right;
    
    }
    
    
    public static int diameter_01(Node node)
    {
    	if(node==null)
    		return 0;
    	int lefth = height(node.left);
    	int righth = height(node.right);
    	
    	int ld = diameter_01(node.left);
    	int rd = diameter_01(node.right);
    	
    	return Math.max(Math.max(ld, rd), lefth+righth+1);
    }
    
    public static diaPair diameter_02(Node node)
    {
    	if(node==null)
    		return new diaPair();
    	diaPair left = diameter_02(node.left);
    	diaPair right = diameter_02(node.right);
    	
    	diaPair myPair = new diaPair();
    	myPair.height = Math.max(left.height, right.height)+1;
    	myPair.dia  = Math.max(Math.max(left.dia, right.dia), left.height+right.height+1);
    	
    	return myPair;
    }
    
    public static Node deleteLeaf_01(Node node,int leaf)
    {
    	if(node==null)
    		return null;
    	
    	if(node.left==null && node.right==null && node.data==leaf)
    		return null;
    	/*if(node.left!=null)
    	{*/
    		node.left =deleteLeaf_01(node.left, leaf);
    	//}
    	/*if(node.right!=null)
    	{*/
    		node.right=deleteLeaf_01(node.right, leaf);
    	//}
    	
    	return node;
    }
    
    
    public static void addLeafNode_01(Node node,int leaf,int par,boolean isleft)
    {
    	if(node==null)
    		return ;
    	
    	if(node.data==par)
    	{
    		if(isleft)
    			node.left = new Node(leaf);
    		node.right = new Node(leaf);
    	}
    	
    	addLeafNode_01(node.left, leaf, par, isleft);
    	addLeafNode_01(node.right, leaf, par, isleft);
    }
    public static Node delete_AnyNode(Node node ,int data)
    {
    	if(node==null) 
    		return null;
    	
    	
    	if(node.left!=null && node.right!=null && node.data==data)
    	{
    		Node right_most = findandReturnNode(node.left, data);
    	}
    	if(node.left!=null)
    	{
    		node.left =deleteLeaf_01(node.left, data);
    	}
    	if(node.right!=null)
    	{
    		node.right=deleteLeaf_01(node.right, data);
    	}
    	
    	return node;
    }
    
    public static void traversals()
    {
    	
    	int pre[]={10,20,40,50,60,30,70,90,80};
    	int inorder[] = {40,20,60,50,10,70,90,30,80,};
    	int post[]={40,60,50,20,90,70,80,30,10};
    	
    	//Node node = preIn(pre, inorder, 0, pre.length-1, 0, inorder.length-1);
    	Node node = post(post, inorder, 0, pre.length-1, 0, inorder.length-1);
    	display(node);
    	
    }
    
    public static Node preIn(int[] pre,int[] in,int ps,int pe,int is,int ie)
    {
    	if(ps>pe || is>ie)
    		return null;
    	
    	Node node = new Node(pre[ps]);
    	int idx = is;
    	
    	while(idx<=ie)
    	{
    		if(in[idx]==pre[ps])
    		{
    			
    			break;
    		}
    		idx++;
    	}
    	
    	int tne = idx-is;
    	node.left=preIn(pre, in, ps+1, ps+tne, is, idx-1);
    	node.right=preIn(pre, in, ps+tne+1, pe, idx+1, ie);
    	
    	return node;
    }
    
    public static Node post(int post[],int in[],int ps,int pe,int is,int ie)
    {
    	if(ps>pe || is>ie)
    	return null;
    	
    	Node node = new Node(post[pe]);
    	int idx=is;
    	while(idx<=ie)
    	{
    		if(in[idx]==post[pe])
    		{
    			break;
    		}
    		idx++;
    	}
    	
    	int tne = idx-is;
    	node.left=post(post, in, ps, ps+tne-1, is, idx-1);
    	node.right=post(post, in, ps+tne, pe-1, idx+1, ie);
    	
    	return node;
    	
    }
    
    static Node head;
    static Node prev_;
    public static Node creatList(Node node)
    {
    	if(node==null)
    		return null;
    	
    	creatList(node.left);
    	if(head==null)
    	{
    		head = node;
    	}
    	else
    	{
    		prev_.right=node;
    		node.left = prev_;
    	}
    	
    	prev_ = node;
    	creatList(node.right);
    	
    	return node;
    	
    	
    	
    }
    
}	


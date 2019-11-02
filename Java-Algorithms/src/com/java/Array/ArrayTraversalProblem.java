package com.java.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayTraversalProblem {

	public  final int ROW = 3;
	public  final int COL = 4;
	
	
	static class Point
	{
		int x;
		int y;
		
		public Point(int row, int col) {
		    this.x = row;
		    this.y = col;
		}
	}
	
	static class QueueNode
	{
		Point pt;
		int dist;
		
		public QueueNode(Point src, int d) {
		    this.pt = src;
		    this.dist = d;
		}
		
	}
	 
	boolean isValid(int row,int col)
	{
		 return (row >= 0) && (row < ROW) && 
		           (col >= 0) && (col < COL); 
	}
	
	int rowNum[] = {-1, 0, 0, 1}; 
	int colNum[] = {0, -1, 1, 0}; 
	
	
	int BFS(int mat[][], Point src, Point dest) 
	{ 
	    // check source and destination cell 
	    // of the matrix have value 1 
	    if (mat[src.x][src.y]!=1 || mat[dest.x][dest.y]!=1) 
	        return -1; 
	  
	    boolean visited[][] =  new boolean[ROW][COL]; 
	    
	      
	    // Mark the source cell as visited 
	    visited[src.x][src.y] = true; 
	  
	    // Create a queue for BFS 
	    Queue<QueueNode> q = new LinkedList<>();
	    
	      
	    // Distance of source cell is 0 
	    QueueNode s = new QueueNode(src,0);
	    
	    
	    q.add(s);  // Enqueue source cell 
	  
	    // Do a BFS starting from source cell 
	    while (!q.isEmpty()) 
	    { 
	        QueueNode curr = q.peek(); 
	        Point pt = curr.pt; 
	  
	        // If we have reached the destination cell, 
	        // we are done 
	        if (pt.x == dest.x && pt.y == dest.y) 
	            return curr.dist; 
	  
	        // Otherwise dequeue the front cell in the queue 
	        // and enqueue its adjacent cells 
	        q.poll(); 
	  
	        for (int i = 0; i < 4; i++) 
	        { 
	            int row = pt.x + rowNum[i]; 
	            int col = pt.y + colNum[i]; 
	              
	            // if adjacent cell is valid, has path and 
	            // not visited yet, enqueue it. 
	            if (isValid(row, col) && mat[row][col]==1 &&  
	               !visited[row][col]) 
	            { 
	                // mark cell as visited and enqueue it 
	                visited[row][col] = true; 
	                QueueNode Adjcell = new  QueueNode(new Point(row, col), 
	                                      curr.dist + 1) ; 
	                q.add(Adjcell); 
	            } 
	        } 
	    } 
	  
	    // Return -1 if destination cannot be reached 
	    return -1; 
	} 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayTraversalProblem ar = new ArrayTraversalProblem();
		
		
		int[][] mat = new int[][] { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
			{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
			{ 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };
/*		
		int [][] mat = new int[][]{
			{1,0,1,1},
			{1,1,0,1},
			{1,1,1,1},
			{1,1,1,1}};
*/			
			/*Point source = new  ArrayTraversalProblem.Point(0, 0);
			Point dest = new ArrayTraversalProblem.Point(2, 3);
			
			int dist = ar.BFS(mat, source, dest);
			
			if (dist != Integer.MAX_VALUE)
			    System.out.println("Shortest Path is " + dist);
			else
			    System.out.println("Shortest Path doesn't exist");
			
			
			*/
			
				int b[][] = new int[mat.length][mat[0].length];
					int minpos = srcToDes(mat, 0, 0, 2, 3, 1, b);
					System.out.println(minpos);

	}
	
	

	private static int srcToDes(int[][] arr, int x1,int y1,int x2, int y2,int move,int[][] b) {
		if(x1==x2 && y1==y2)
			return 0;
		else if(x1>=arr.length || x1<0 || y1>=arr[0].length || y1<0)
			return Integer.MAX_VALUE;
		else if(arr[x1][y1]==0)
			return Integer.MAX_VALUE;
		else if(b[x1][y1]==1)
			return Integer.MAX_VALUE;
		else
		{
			
			int left=Integer.MAX_VALUE;
			int right=Integer.MAX_VALUE;
			int top=Integer.MAX_VALUE;
			int bottom=Integer.MAX_VALUE;
			if(move!=1)
			{
				b[x1][y1]=1;
				left=srcToDes(arr,x1,y1-1,x2,y2,2,b);
				b[x1][y1]=0;
			}
			if(move!=2)
			{
				b[x1][y1]=1;
				right=srcToDes(arr,x1,y1+1,x2,y2,1,b);
				b[x1][y1]=0;
			}
			if(move!=3)
			{
				b[x1][y1]=1;
				top=srcToDes(arr,x1-1,y1,x2,y2,4,b);
				b[x1][y1]=0;
			}
			if(move!=4)
			{
				b[x1][y1]=1;
				bottom=srcToDes(arr,x1+1,y1,x2,y2,3,b);
				b[x1][y1]=0;
			}
			if(Math.min(left,Math.min(right, Math.min(top, bottom)))==Integer.MAX_VALUE)
			{
				return Integer.MAX_VALUE;
			}
			return 1+Math.min(left,Math.min(right, Math.min(top, bottom))) ;
		}
	}
}

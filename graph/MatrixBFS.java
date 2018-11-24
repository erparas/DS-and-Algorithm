package graph;

import java.util.*;

class Point
{
	int x,y;
	public Point(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public ArrayList<Point> getNeighbour()
	{
		ArrayList<Point> al= new ArrayList<>();
		al.add(new Point(this.x-1,this.y));
		al.add(new Point(this.x,this.y-1));
		al.add(new Point(this.x+1,this.y));
		al.add(new Point(this.x,this.y+1));
		return al;
	}
}

class Cell
{
	Point p;
	int distance;
	public Cell(Point p,int distance)
	{
		this.p = p;
		this.distance = distance;
				
	}
}

public class MatrixBFS {
	
	int row = 9,column=10;
	
	public static boolean isValid(Point p)
	{
		if(p.x >=0 && p.x <9 && p.y>=0 && p.y <10)
			return true;
		return false;
	}
	
	public static int BFS(int[][] mat,Point source,Point dest)
	{
		if(mat[source.x][source.y]==0 || mat[dest.x][dest.y]==0)
			return -1;
		
		LinkedList<Cell> dequeue = new LinkedList<>();
		
		boolean[][] isVisited = new boolean[9][10];
		for(boolean[] var : isVisited)
			Arrays.fill(var, false);
		dequeue.add(new Cell(source,0));
		
		Cell c;
		while(dequeue.size()!=0)
		{
			c = dequeue.poll();
			System.out.println("For element : x : +"+c.p.x+" : y : "+c.p.y);
			if(c.p.x == dest.x && c.p.y == dest.y)
			{	
				System.out.println("Element found !");
				return c.distance;
			}
			
			for(Point neigh : c.p.getNeighbour())
			{
				if(isValid(neigh) && mat[neigh.x][neigh.y]==1)
				{
					if(!isVisited[neigh.x][neigh.y])
					{
						System.out.println(" Adding element : ["+neigh.x+"]["+neigh.y+"]");
						isVisited[neigh.x][neigh.y] = true;
						dequeue.add(new Cell(neigh,c.distance+1));
					}
					
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		int mat[][] = 
		    { 
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
		        { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
		        { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
		        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
		        { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
		        { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
		        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
		        { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
		        { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } 
		    }; 
		  
		    Point source = new Point(0,0); 
		    Point dest = new Point(3,4);
		  
		    int dist = BFS(mat, source, dest); 
		  
		    if(dist != -1)
		    	System.out.println(" distance is : "+dist);
		    else
		    	System.out.println(" distance does not exist !");
		    
	}

}

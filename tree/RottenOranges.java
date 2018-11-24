package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class RottenOranges {
	static int m =3;
	static int n =5;

	static class Point
	{
		int x,y;
		public Point(int x,int y)
		{
			this.x = x;
			this.y =y;
		}
	}

	public static boolean delim(Point x)
	{
		return x.x ==-1 && x.y==-1;
	}

	public static ArrayList<Point> getAdjacents(Point p)
	{
		ArrayList<Point> al = new ArrayList<>();
		al.add(new Point(p.x-1,p.y));
		al.add(new Point(p.x+1,p.y));
		al.add(new Point(p.x,p.y-1));
		al.add(new Point(p.x,p.y+1));
		return al;
	}

	public static boolean checkFresh(int [][]check)
	{
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				if(check[i][j]==1)
					return true;
		return false;
	}
	
	public static int rottenOranges(int [][]oranges)
	{
		int rotten[][] = new int[m][n];

		LinkedList<Point> queue = new LinkedList<>();

		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				if(oranges[i][j]==2)
					queue.add(new Point(i,j));

		}
		Point temp;
		int ans=0;
		queue.add(new Point(-1,-1));
		while(!queue.isEmpty())
		{
			boolean flag=false;
			while(!delim(queue.peek()))
			{
				temp = queue.peek();
				for(Point p : getAdjacents(temp))
				{
					if(isValidOrange(p) && oranges[p.x][p.y] ==1)
					{
						oranges[p.x][p.y]=2;
						queue.add(p);
						if(!flag)
						{
							flag=true;
							ans++;
						}
					}
				}
				queue.remove();
				
			}
			
			
			queue.remove();
			if(!queue.isEmpty())
			{
				queue.add(new Point(-1,-1));
			}
			
			
		}

		if(!checkFresh(oranges))
		{
			System.out.println(" All done ");
			return ans;
		}


		return -1;
	}

	public static boolean isValidOrange(Point p)
	{
		if(p.x>=0 && p.x<m && p.y>=0 && p.y<n)
			return true;
		else return false;
	}

	public static void main(String[] args)
	{
		int arr[][] = {{2, 1, 0, 2, 1},
		 {0, 0, 1, 2, 1},
		 {1, 0, 0, 2, 1} };
		int time = rottenOranges(arr);
		if(time == -1)
			System.out.println(" ORanges cannot be rot");
		else
			System.out.println(" Oranges can be rot in :"+time);
	}
}

package graph;

public class DFSIsland {

	private static int ROW = 5;
	private static int COL = 5;
	
	public boolean isSafe(int i,int j,int [][]M,boolean [][]visited)
	{
		return (i>=0 && i<ROW && j>=0 && j<COL) && (M[i][j]==1 && !visited[i][j]);
	}
	
	public void DFS(int [][]M,int i,int j,boolean [][]visited)
	{
		int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1}; 
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        
		visited[i][j]=true;
		for(int k =0;k<8;k++)
		{
			if(isSafe(i+rowNbr[k],j+colNbr[k],M,visited))
			{
				DFS(M,i+rowNbr[k],j+colNbr[k],visited);
			}
		}
		
	}
	
	public int countIsland(int [][]M)
	{
		boolean [][]visited = new boolean[ROW][COL];
		
		int count =0;
		for(int i =0;i<ROW;i++)
		{
			for(int j=0;j<COL;j++)
			{
				if(M[i][j]==1 && !visited[i][j])
				{
					DFS(M,i,j,visited);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String []args)
	{
		int [][]M = {{1, 1, 0, 0, 0}, 
                {0, 1, 0, 0, 1}, 
                {1, 0, 0, 1, 1}, 
                {0, 0, 0, 0, 0}, 
                {1, 0, 1, 0, 1} 
               }; 
		DFSIsland a = new DFSIsland();
		int count = a.countIsland(M);
		System.out.println(" the count is : "+count);
	}
	
}

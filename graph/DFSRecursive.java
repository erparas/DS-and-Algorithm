package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSRecursive {
	
	private static int V;
	
	private static LinkedList<Integer> adj[];
	
	public DFSRecursive(int v)
	{
		this.V = v;
		adj = new LinkedList[v];
		for(int i =0;i<v;i++)
			adj[i]= new LinkedList<Integer>();
	}
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
	}
	
	public void DFS(int v)
	{
		boolean []visited = new boolean[V];
		for(int i =0;i<V;i++)
		{
			if(!visited[i])
				DFSUtil(i,visited);
		}
		
		
	}
	
	public void DFSUtil(int v, boolean[]visited)
	{
		visited[v]=true;
		System.out.println(" "+v);
		Iterator<Integer> itr = adj[v].iterator();
		while(itr.hasNext())
		{
			//System.out.println(" Element exist");
			int n = itr.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	public static void main(String[] args)
	{
		DFSRecursive graph = new DFSRecursive(4);
		graph.addEdge(0, 1);
		graph.addEdge(0,2);
		graph.addEdge(1,2);
		graph.addEdge(2,0);
		
		graph.addEdge(2, 3);
		
		graph.addEdge(3, 3);
		
		System.out.println(" printing the DFS for graph : ");
		graph.DFS(2);
		
	}
}

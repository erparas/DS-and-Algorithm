package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {

	private static int V;
	private static LinkedList<Integer> adj[];

	public DFSGraph(int v)
	{
		this.V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]= new LinkedList();
		}
	}

	void addEdge(int v,int w)
	{
		adj[v].add(w);
	}

	public static void DFS(int v)
	{
		boolean []visited = new boolean[V];
		DFSUtil(v,visited);
	}

	public static void DFSUtil(int v,boolean[] visited)
	{
		//visited[v]=true;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.push(v);

		while(!queue.isEmpty())
		{
			v= queue.pop();
			if(visited[v]==false)
			{
				System.out.println(" "+v);
				visited[v]=true;
			}
			Iterator<Integer> itr = adj[v].iterator();
			while(itr.hasNext())
			{
				int s= itr.next();
				if(!visited[s])
				{
					//System.out.println("adding to stack : "+s);
					queue.push(s);
				}
			}

		}

	}

	public static void main(String[] args)
	{
		DFSGraph graph = new DFSGraph(4);

		graph.addEdge(0, 1);
		graph.addEdge(0,2);
		graph.addEdge(1,2);
		graph.addEdge(2, 3);
		graph.addEdge(2,0);
		
		graph.addEdge(3, 3);

		/*	 DFSGraph g = new DFSGraph(6); 
	        g.addEdge(5, 2); 
	        g.addEdge(5, 0); 
	        g.addEdge(4, 0); 
	        g.addEdge(4, 1); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 1); */
		System.out.println(" printing the DFS for graph : ");
		graph.DFS(2);

	}

}

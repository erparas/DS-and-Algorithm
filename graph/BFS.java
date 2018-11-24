package graph;

import java.util.*;

class Graph1
{
	private int v;
	
	private LinkedList<Integer> adj[];
	
	public Graph1(Integer v)
	{
		this.v = v;
		adj = new LinkedList[v];
		for(int i =0;i<v;i++)
			adj[i] = new LinkedList();
	}
	void addEdge(int v,int w)
	{
		adj[v].add(w);
	//	adj[w].add(v);
	}
	
	void BFS(int s)
	{
		boolean visited[] = new boolean[v];
		
		visited[s] = true;
		
		//create a queue for BFS
		LinkedList<Integer> dequeue = new LinkedList<Integer>();
		dequeue.add(s);
		
		while(dequeue.size() !=0 )
		{
			s = dequeue.poll();
			System.out.println(s+" ");
			
			for(int i: adj[s])
			{
				if(!visited[i])
				{
					visited[i]=true;
					dequeue.add(i);
				}
			}
		}
		
		
		
	}
}

public class BFS {
	
	public static void main(String[] args)
	{
		Graph1 g = new Graph1(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		System.out.println("BFS for vertex 2");
		g.BFS(2);
	}

}

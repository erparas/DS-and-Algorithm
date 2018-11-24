package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinSumLeaf {
	
	public static class Node
	{
		int data;
		Node left,right;
		public Node(int d)
		{
			data=d;
			left = right = null;
			
		}
	}
	
	public int calculateMinSum(Node head)
	{
		int sum=0;
		
		boolean found=false;
		Queue<Node> q = new LinkedList();
		q.add(head);
		if(head == null) return 0;
		if(head.left == null && head.right ==null)
			return head.data;
		
		
		while (found == false)
		{
			int nc = q.size();
			while((nc--)>0)
			{
				Node temp = q.poll();
				if(temp.left == null && temp.right == null)
				{
					sum+=temp.data;
					found=true;
				}
				else
				{
					if(temp.left !=null)
						q.add(temp.left);
					if(temp.right!=null)
						q.add(temp.right);
				}
			}
		}
		
		return sum;
	}
	
	public Node head;
	
	public static void main(String []args)
	{
		MinSumLeaf a = new MinSumLeaf();
		a.head = new Node(1);
		a.head.left = new Node(2);
		a.head.right = new Node(3);
		a.head.left.left = new Node(4); 
	    a.head.left.right = new Node(5); 
	    a.head.right.left = new Node(6); 
	    a.head.right.right = new Node(7); 
	    a.head.left.right.left = new Node(8); 
	    a.head.right.left.right = new Node(9);
	    
	    int sum = a.calculateMinSum(a.head);
	    System.out.println(sum);
		
	}

}

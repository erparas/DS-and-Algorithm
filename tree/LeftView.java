package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
	
	static class Node
	{
		int data;
		Node left,right;
		public Node(int d)
		{
			data = d;
			left = right = null;
		}
	}
	
	public static void printLeftView(Node head)
	{
		Node temp  = head;
		int level = 0;
		Queue<Node> q = new LinkedList();
		q.add(head);
		boolean flag = false;
		while(!q.isEmpty())
		{
			temp = q.poll();
			if(!flag)
			{
				System.out.println(temp.data);
				flag=true;
			}
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}
	
	static Node root;
	
	public static void main(String[] args)
	{
		LeftView tree = new LeftView(); 
        tree.root = new Node(12); 
        tree.root.left = new Node(10); 
        tree.root.right = new Node(30); 
        tree.root.right.left = new Node(25); 
        tree.root.right.right = new Node(40);
        printLeftView(tree.root);
	}

}

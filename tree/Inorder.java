package tree;

import java.util.LinkedList;



public class Inorder {

	static class Node
	{
		int key;
		Node left,right;

		public Node(int key)
		{
			this.key = key;
			this.left = this.right = null;
		}
	}

	static Node root;
	static Node temp = root;

	public static void inorderTraversal(Node temp)
	{
		if(temp == null)
		{
			return;
		}
		//System.out.println("going left");
		inorderTraversal(temp.left);
		System.out.print(temp.key+" ");
		inorderTraversal(temp.right);
	}

	public static void insert(Node root, int key)
	{
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			root = queue.poll();
			if(root.left == null)
			{
				root.left = new Node(key);
				break;
			}
			else
				queue.add(root.left);
			if(root.right == null)
			{
				root.right = new Node(key);
				break;
			}
			else
				queue.add(root.right);
		}
	}

	public static void delete(Node root,int key)
	{
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		Node keyNode=null,deepNode=null;
		while(!queue.isEmpty())
		{
			deepNode = queue.poll();
			if(deepNode.key == key)
				keyNode = deepNode;
			else
				if(deepNode.left!=null)
					queue.add(deepNode.left);
				if(deepNode.right !=null)
					queue.add(deepNode.right);
		}
		int x = deepNode.key;
		System.out.println(" deepNode : "+deepNode.key+" keyNode : "+keyNode.key);
		deleteDeepest(root,deepNode);
		keyNode.key = x;
	}

	public static void deleteDeepest(Node root, Node deepNode)
	{
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		Node temp;
		while(!queue.isEmpty())
		{
			temp = queue.poll();
			if(temp.right!=null)
			{
				if(temp.right == deepNode)
				{
					temp.right=null;
					return;
				}
				else
					queue.add(temp.right);
			}
			if(temp.left !=null)
			{
				if(temp.left == deepNode)
				{
					temp.right=null;
					return;
				}
				else
					queue.add(temp.left);
			}


		}
	}




	public static void main(String[] args)
	{
		root = new Node(10);
		root.left = new Node(11);
		root.left.left = new Node(7);
		root.left.right = new Node(12);
		root.right = new Node(9);
		root.right.left = new Node(15);
		root.right.right = new Node(8);

		System.out.println("pritnign the inoder : ");
		inorderTraversal(root);
		//insert(root,12);
		delete(root,11);
		System.out.println("pritnign the inoder : ");
		inorderTraversal(root);
	}

}

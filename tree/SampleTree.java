package tree;

class Node
{
	int data;
	Node left,right;
	Node(int data)
	{
		this.data = data;
		this.left=null;
		this.right=null;
	}
}

public class SampleTree {

	Node root;
	
	public static void main(String[] args)
	{
		SampleTree st = new SampleTree();
		st.root = new Node(5);
		st.root.left = new Node(4);
		st.root.right = new Node(6);
		st.root.left = new Node(2);
		//printTree(root);
	}
	
	public static void printTree(Node n)
	{
		
	}
}

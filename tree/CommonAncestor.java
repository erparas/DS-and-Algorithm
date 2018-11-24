package tree;

public class CommonAncestor {
	
	public Node head;
	public static class Node
	{
		int data;
		Node left,right;
		public Node(int d)
		{
			data=d;
			left=null;
			right=null;
		}
	}
	
	public CommonAncestor(int d)
	{
		this.head = new Node(d);
	}
	
	public int findCommonAncestor(Node temp,int m,int n)
	{
		//Node temp = head;
		if(temp == null)
			return -1;
		while(temp!=null)
		{
			System.out.println(" Temp data : "+temp.data);
			if(temp.data>m && temp.data>n)
				temp=temp.left;
			else if(temp.data < m && temp.data < n)
				temp=temp.right;
			else return temp.data;
		}
		return -1;
		
	}
	
	public static void main(String []args)
	{
		CommonAncestor a = new CommonAncestor(20);
		a.head.left = 		new Node(8);
		a.head.right = 		new Node(22);
		a.head.left.left   = new Node(4); 
		a.head.left.right        = new Node(12); 
	    a.head.left.right.left  = new Node(10); 
	    a.head.left.right.right = new Node(14); 
	    
	    int count = a.findCommonAncestor(a.head,10,22);
	    System.out.println(" LCA : "+count);
	}

}

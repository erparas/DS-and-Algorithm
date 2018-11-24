package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode
{
	int data;
	int hd;
	TreeNode left,right;
	public TreeNode(int data)
	{
		this.data = data;
		this.hd = Integer.MAX_VALUE;
		left = right = null;
	}
}

public class BottomViewTree {
	
	TreeNode root;
	
	public BottomViewTree()
	{
		
	}
	public BottomViewTree(TreeNode val)
	{
		root= val;
	}
	
	public void printBottomView(TreeNode root)
	{
		if(root == null)
			return;
		Queue<TreeNode> q = new LinkedList();
		Map<Integer,Integer> hmap = new TreeMap();
		q.add(root);
		int hd =0;
		root.hd=hd;
		
		hmap.put(hd, root.data);
		while(q.size()>0)
		{
			TreeNode temp = q.poll();
			
			hd = temp.hd;
			hmap.put(hd, temp.data);
			if(temp.left!=null)
			{
				temp.left.hd=hd-1;
				q.add(temp.left);
			
			}
			if(temp.right!=null)
			{
				q.add(temp.right);
				temp.right.hd=hd+1;
				
			}
			
		}
		for(Integer e : hmap.values())
		{
			System.out.println(" "+e);
		}
	}
	
	public static void main(String []args)
	{
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(25);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		BottomViewTree b= new BottomViewTree(root);
		b.printBottomView(root);
		
	}
	
	

}

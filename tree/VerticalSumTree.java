package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNodes
{
	int data;
	int hd;
	TreeNodes left,right;
	public TreeNodes(int data)
	{
		this.data = data;
		this.hd = Integer.MAX_VALUE;
		left = right = null;
	}
}

public class VerticalSumTree {
	
	TreeNodes root;
	
	public VerticalSumTree()
	{
		
	}
	public VerticalSumTree(TreeNodes val)
	{
		root= val;
	}
	
	public void printBottomView(TreeNodes root)
	{
		if(root == null)
			return;
		Queue<TreeNodes> q = new LinkedList();
		Map<Integer,Integer> hmap = new TreeMap();
		q.add(root);
		int hd =0;
		root.hd=hd;
		
		hmap.put(hd, root.data);
		while(q.size()>0)
		{
			TreeNodes temp = q.poll();
			
			hd = temp.hd;
			int tempval = hmap.get(hd) == null ? 0 : hmap.get(hd);
			hmap.put(hd, tempval+temp.data);
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
		/*TreeNodes root = new TreeNodes(20);
		root.left = new TreeNodes(8);
		root.right = new TreeNodes(22);
		root.left.left = new TreeNodes(5);
		root.left.right = new TreeNodes(3);
		root.right.left = new TreeNodes(4);
		root.right.right = new TreeNodes(25);
		root.left.right.left = new TreeNodes(10);
		root.left.right.right = new TreeNodes(14);*/
		
		TreeNodes root = new TreeNodes(1);
		root.left = new TreeNodes(2);
		root.right = new TreeNodes(3);
		root.left.left = new TreeNodes(4);
		root.left.right = new TreeNodes(5);
		root.right.left = new TreeNodes(6);
		root.right.right = new TreeNodes(7);
		VerticalSumTree b= new VerticalSumTree(root);
		b.printBottomView(root);
		
	}
	
	

}

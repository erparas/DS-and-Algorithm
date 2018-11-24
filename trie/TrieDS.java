package trie;

public class TrieDS {
	
	static final int alphabetSize= 26;
	static class TrieNode
	{
		boolean isEndOfWord;
		TrieNode[] children = new TrieNode[alphabetSize];
		public TrieNode()
		{
			isEndOfWord=false;
			for(int i=0;i<alphabetSize;i++)
				this.children[i]=null;
		}
	}
	
	static TrieNode root;
	
	public static void insert(String key)
	{
		int length = key.length();
		TrieNode p =root;
		int index;
		for(int i=0;i<length;i++)
		{
			index=key.charAt(i)-'a';
			if(p.children[index]==null)
			{
				p.children[index]=new TrieNode();
			}
			p=p.children[index];
		}
		p.isEndOfWord=true;
	}
	
	public static boolean search(String key)
	{
		int index;
		int length = key.length();
		TrieNode temp = root;
		for(int i =0;i<length;i++)
		{
			index = key.charAt(i)-'a';
			if(temp.children[index] == null)
				return false;
			temp = temp.children[index];
		}
		return temp.isEndOfWord && temp !=null;
		
		//return false;
	}
	
	public static void delete(String key){
		if(root == null || key == null)
			{
			System.out.println(" Key cannot be deleted !");
			return ;
			}
		else 
		{
			boolean dd = deleteHelper(key,root,key.length(),0);
			System.out.println(" value fo delete dd : "+dd);
		}
		return ;
	}
	
	public static boolean hasNoChildren(TrieNode troot)
	{
		for(int i=0;i<alphabetSize;i++)
		{
			if(troot.children[i]!=null)
				return false;
		}
		return true;
	}
	
	public static boolean deleteHelper(String key,TrieNode currentNode,int length,int level)
	{
		if(currentNode == null)
		{
			System.out.println(" key does not exists !");
			return false;
		}
		boolean self_deleted = false;
		
		if(length == level)
		{
			if(hasNoChildren(currentNode))
			{
				currentNode =null;
				self_deleted=true;
			}
			
			else
			{
				currentNode.isEndOfWord=false;
				self_deleted=false;
			}
		}
		else
		{
			TrieNode childNode = currentNode.children[key.charAt(level)-'a'];
			boolean childDelete = deleteHelper(key,childNode,length,level+1);
			if(childDelete)
			{
				currentNode.children[key.charAt(level)-'a']=null;
				if(currentNode.isEndOfWord==true)
					self_deleted=false;
				if(!hasNoChildren(currentNode))
					self_deleted=false;
				else
				{
					currentNode=null;
					self_deleted=true;
				}
				
			}
			else
				self_deleted=false;
			
		}
		
		return self_deleted;
			
	}
	
	
	public static void main(String []args)
	{
		String[] input = {"the","there","answer","a","then"};
		String[] output = {"future","then"};
		TrieDS d = new TrieDS();
		root = new TrieNode();
		for(int i =0;i<input.length;i++)
		{
			insert(input[i]);
		}
		delete("the");
		if(search("the"))
			System.out.println(" element found !");
		else System.out.println(" element not found !");
	}
}

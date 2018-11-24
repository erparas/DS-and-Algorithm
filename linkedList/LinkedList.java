package linkedList;

public class LinkedList {

	class Node
	{
		int data;
		Node next;
		Node(int n)
		{
			this.data = n;
			this.next = null;
		}
	}
	
	public Node head;
	
	public void push(int n)
	{
		Node x = new Node(n);
		x.next=head;
		head = x;
	}
	public void printAll()
	{
		Node x = head;
		while(x!=null)
			{
			System.out.println(x.data);
			x=x.next;
			}
	}
	
	public void pushEnd(int n)
	{
		Node x = head;
		Node y = new Node(n);
		while(x.next!=null)
			x=x.next;
		x.next = y;
	
		
	}
	public static void main(String []args)
	{
		LinkedList a = new LinkedList();
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(4);
		a.pushEnd(5);
		a.printAll();
		
		
	}
}

package linkedList;

public class ReversePrint {
	
	Node head;
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next =null;
				
		}
	}
	
	public void addNode(int d)
	{
	//	Node dd = head;
		Node temp = new Node(d);
		temp.next = head;
		head = temp;
		
	}
	
	public void printList(Node head)
	{
		if(head == null)
			return;
		
		printList(head.next);
		System.out.println(head.data);
	/*	while(head!=null)
			{
				System.out.println(head.data);
				head=head.next;
			}
	*/		
	}
	
	public static void main(String []args)
	{
		ReversePrint d = new ReversePrint();
		d.head =  d.new Node(4);
		d.addNode(3);
		d.addNode(2);
		d.addNode(1);
		d.addNode(0);

		
		d.printList(d.head);
		System.out.println(" hello ");
	}

}

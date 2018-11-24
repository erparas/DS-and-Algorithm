package misc;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumber {
	
	public static void printBinary(int n)
	{
		Queue<String> q = new LinkedList<String>();
		
		q.add("1");
		String number,temp;
		while(n-- >0)
		{
			number = q.poll();
			System.out.println(number);
			q.add(number+"0");
			q.add(number+"1");
			
			
		}
	}
	
	public static void main(String[] args)
	{
		int n=10;
		printBinary(n);
	}

}

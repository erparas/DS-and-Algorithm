package misc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SplitWise {
	
	static class DebtFriend implements Comparable<DebtFriend>
	{
		int friend;
		int debt;
		public DebtFriend(int a,int b)
		{
			this.friend=a;
			this.debt = b;
		}
		
		@Override
		public int compareTo(DebtFriend w) {
			// TODO Auto-generated method stub
			return w.debt-this.debt;
		}
	}
	
	public static void calculate(int [][]graph)
	{
		System.out.println(" length : "+graph.length);
		int [] totalDebt = new int[graph.length];
		Arrays.fill(totalDebt, 0);
		for(int i =0;i<graph.length;i++)
		{
			for(int j=0;j<graph.length;j++)
			{
				totalDebt[i]+=graph[i][j]-graph[j][i];
			}
		}
		
		
		
		Queue<DebtFriend> creditq = new PriorityQueue<DebtFriend>();
		Queue<DebtFriend> debtq = new PriorityQueue<DebtFriend>();
		
		

		for(int i=0;i<graph.length;i++)
		{
			if(totalDebt[i]<0)
				creditq.add(new DebtFriend(i,-totalDebt[i]));
			if(totalDebt[i]>0)
				debtq.add(new DebtFriend(i,totalDebt[i]));
		}
		int amount =0;
		int credit=0,debt=0;
//		while(debtq.size()>0)
//		{
//		//	System.out.println(debtq.poll().debt);
//		}
//		
		while(creditq.size()>0 && debtq.size()>0)
		{
			credit = creditq.peek().debt;
			debt = debtq.peek().debt;
			if(credit == debt)
			{
				System.out.println(creditq.peek().friend+" will get  "+credit+"from "+debtq.peek().friend);
				creditq.poll();
				debtq.poll();
			}
			else if(credit > debt)
			{
				System.out.println(creditq.peek().friend+" will get  "+debt+"from "+debtq.peek().friend);
				creditq.add(new DebtFriend(creditq.peek().friend,(credit-debt)));
				creditq.poll();
				debtq.poll();
			}
			else if(debt > credit)
			{
				System.out.println(creditq.peek().friend+" will get  "+credit+"from "+debtq.peek().friend);
				debtq.add(new DebtFriend(creditq.peek().friend,(debt-credit)));
				creditq.poll();
				debtq.poll();
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		int graph[][] = { {0, 1000, 2000}, 
                {0, 0, 5000}, 
                {0, 0, 0},
                };
		
		calculate(graph);
	}

}

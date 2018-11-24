package dynamicprogramming;

public class CoinProblem {
	
	public static int calculate(int [] coins,int amount)
		{
			int solution[][] = new int[coins.length+1][amount+1];
			
			//for amount 0 return empty set with 1
			
			for(int i=0;i<=coins.length;i++)
			{
				solution[i][0] = 1;
			}
			
			//with no coins return 0
			
			for(int j =0;j<=amount;j++)
			{
				solution[0][j] = 0;
			}
			
			//initialize for rest
			for(int i=1;i<=coins.length;i++)
			{
				for(int j=1;j<=amount;j++)
				{
					//if coin is less than amount
					//then subproblem with inclusion as well as exlusion
					if(coins[i-1]<=j)
					{
						solution[i][j]= solution[i-1][j]+solution[i][j-coins [i-1] ];
					}
					else
						solution[i][j] = solution[i-1][j];
				}
			}
			
			for(int i =0;i<=coins.length;i++)
			{
				for(int j=0;j<=amount;j++)
				{
					System.out.print(solution[i][j]+" ");
				}
				System.out.println();
			}
			
			return solution[coins.length][amount];
		
	}
	
	public static void main(String args[])
	{
		int []v = new int[] {1,2,3};
		int count = calculate(v,4);
		System.out.println(" count : "+count);
	}

}

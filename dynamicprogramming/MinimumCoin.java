package dynamicprogramming;

public class MinimumCoin {

	public static int minCoins(int[] coins, int amount)
	{
		int [][]solution = new int[coins.length+1][amount+1];
		
		//for 0 amount
		for(int i=0;i<=coins.length;i++)
			solution[i][0]=0;
		
		for(int j=0;j<=amount;j++)
			solution[0][j]= Integer.MAX_VALUE;
		
		for(int i=1;i<=coins.length;i++)
		{
			for(int j=1;j<=amount;j++)
			{
				if(coins[i-1]<=j && Integer.MAX_VALUE !=solution[i][j-coins[i-1]])
				{
					//System.out.println("i : "+i+" : j :"+j+"coins[i-1] : "+coins[i-1]);
					//System.out.println("solution[i-1][j] :"+solution[i-1][j]);
					//System.out.println(" solution[i][j-coins[i]] : "+solution[i][j-coins[i-1]]);
					solution[i][j]= Math.min(solution[i-1][j], 1+solution[i][j-coins[i-1]]);
					
				}
				else
					solution[i][j]= solution[i-1][j];
			}
		}
		if (solution[coins.length][amount] != Integer.MAX_VALUE)
		return solution[coins.length][amount];
		else
			return 0;
	}
	
	
	public static void main(String[] args)
	{
		int []coins = new int[]{4,8,14,20,2};
		
		int min = minCoins(coins,22);
		
		System.out.println("Min coins : "+min);
		
	}
	
}

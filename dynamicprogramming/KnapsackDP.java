package dynamicprogramming;

public class KnapsackDP {

	public static int knapsack(int []val,int []w,int W,int n)
	{
		int [][]solution = new int[n+1][W+1];
		int i,j;
		for( i =0;i<=n;i++)
		{
			for( j =0;j<=W;j++)
			{
				if(i==0 || j==0)
				{	solution[i][j]=0;
				}
				else if(w[i-1] <= j)
				{
					solution[i][j] = Math.max(val[i-1]+solution[i-1][j-w[i-1]], solution[i-1][j]);
				}
				else
					solution[i][j] = solution[i-1][j];

			}
		}

		return solution[n][W];
	}


	public static void main(String[] args)
	{

		int val[] = new int[]{60, 100, 120}; 
		int wt[] = new int[]{10, 20, 30}; 

		int W =50;
		int n = val.length;

		int count=knapsack(val,wt,W,n);

		System.out.println(" count : "+count);
	}
}

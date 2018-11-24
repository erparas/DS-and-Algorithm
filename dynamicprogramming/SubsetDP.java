package dynamicprogramming;

public class SubsetDP {

	public static int subsetDP(int []arr,int length,int target)
	{
		int [][]solution = new int[length+1][target+1];
		for(int i=0;i<=length;i++)
			solution[i][0]=0;
		for(int j=0;j<=target;j++)
			solution[0][j]=0;
		
		for(int i=1;i<=length;i++)
		{
			for(int j=1;j<=target;j++)
			{
				if(arr[i-1] <=j)
				{
					solution[i][j]=Math.max(solution[i-1][j],arr[i-1]+solution[i][j-arr[i-1]]);
				}
				else
					solution[i][j]=solution[i-1][j];
			}
		}
		for(int i=0;i<=length;i++)
		{
			for(int j=0;j<=target;j++)
			{
				//System.out.print(" "+solution[i][j]);
			}
		//	System.out.println();

		}
		return solution[length][target];
	}
	public static void main(String []args)
	{
		int arr[]= {1,2,4,6};
		int sum = subsetDP(arr,arr.length,3);
		System.out.println(" count : "+sum);

	}

}

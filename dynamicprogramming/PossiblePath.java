package dynamicprogramming;

public class PossiblePath {

	public static int possiblePath(int m,int n)
	{
		int[][] count = new int[m][n];
		for(int i=0;i<n;i++)
			count[0][i]=1;
		for(int j=0;j<m;j++)
			count[j][0]=1;
		
		for(int i =1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				count[i][j] = count[i-1][j]+count[i][j-1];
				String p="test";
				;
				
			}
		}
		
		return count[m-1][n-1];
	}
	
	public static void main(String[] args)
	{
		System.out.println("Possible path : "+possiblePath(3,3));
	}
	
}

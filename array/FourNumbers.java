package array;

import java.util.Arrays;

public class FourNumbers {
	
	static class PairSum implements Comparable<PairSum>
	{
		int first,second,sum;
		PairSum(int first,int second,int sum)
		{
			this.first = first;
			this.second = second;
			this.sum = sum;
		}
		
		public int compareTo(PairSum comparePair)
		{
			return this.sum - comparePair.sum;
		}
	}
	
	public static boolean notCommon(PairSum p1,PairSum p2)
	{
		return (p1.first != p2.first && p1.first !=p2.second && p1.second != p2.first && p1.second !=p2.second);
		
	}
	public static void findFourElements(int []arr,int length,int N )
	{
		PairSum aux[] = new PairSum[(length)*(length-1)/2];
		int k=0,i=0,j=0;
		for( i=0;i<length-1;i++)
		{
			for( j=i+1;j<length;j++)
			{
				//System.out.println(arr[i]);
				aux[k] = new PairSum(arr[i],arr[j],(arr[i]+arr[j]));
				
				
				k++;
				
			}
		}
		Arrays.sort(aux);
		i=0;
		j=aux.length-1;
		while(i<aux.length && j>=0)
		{
			if((aux[i].sum+aux[j].sum) == N && notCommon(aux[i],aux[j]))
			{
				System.out.println(aux[i].first+" "+aux[i].second+" "+aux[j].first+" "+aux[j].second+" ");
				break;
			}
			else if((aux[i].sum+aux[j].sum)<N)
				i++;
			else j--;
		}
		
		
		
		
	}
	public static void main(String [] args)
	{
		int arr[] = {10,20,30,40,1,2};
		
		findFourElements(arr,arr.length,91);
		
	}
	
}

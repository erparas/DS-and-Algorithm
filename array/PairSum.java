package array;

import java.util.HashMap;
import java.util.Map.Entry;


public class PairSum {

	static int arr[] = new int[]{ 1, 5, 7, -1, 5 };
	public static int getPairCount(int[] arr,int sum)
	{
		HashMap<Integer,Integer> hmap = new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{	

			if(!hmap.containsKey(arr[i]))
			{
				hmap.put(arr[i], 1);
			}
			else
			{
				//	System.out.println("increasing the count");
				hmap.put(arr[i], hmap.get(arr[i])+1);
			}
		}
		int twice_count=0;
		Boolean toPrint=false;
		for(int i=0;i<arr.length;i++)
		{
			if(hmap.get(sum-arr[i])!=null)
			{	
				twice_count+=hmap.get(sum-arr[i]);
				for(int j=0;j<hmap.get(sum-arr[i]);j++)
					System.out.println(arr[i] + " : "+ (sum-arr[i]));
			}
			if(sum-arr[i]==arr[i])
			{
				twice_count--;
			}
		}
		return twice_count/2;
		//	return "";
	}
	public static void main(String[] args)
	{

		System.out.println("count : "+getPairCount(arr, 6));
	}


}

package array;

public class SecondLargest {
	
	public static void main(String[] args)
	{
		int []arr= {12, 35, 1, 10, 34, 1}; 
		int first,second;
		first = second = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>first)
			{
				second=first;
				first=arr[i];
				
			}
			else
				if(arr[i]<first && arr[i]>second)
					second = arr[i];
		}
		System.out.println(" first : "+first+" second : "+second);
	}

}

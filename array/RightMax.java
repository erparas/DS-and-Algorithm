package array;

public class RightMax {
	
	public static int[] count(int[] arr,int length)
	{
		int rmax = arr[length-1];
		arr[length-1]=-1;
		for(int i = length-2;i>=0;i--)
		{
			int temp=arr[i];
			arr[i]=rmax;
			if(temp>rmax)
			{
				rmax=temp;
				
			}
		}
		return arr;
	}
	
	
	public static void main(String[] args)
	{
		int a[] = {16, 17, 4, 3, 5, 2};
		int []arr= count(a,a.length);
		for(int k : arr)
		{
			System.out.print(" "+k);
		}
		
	}

}

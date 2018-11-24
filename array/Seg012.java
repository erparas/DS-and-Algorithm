package array;

public class Seg012 {
	
	public static void seg(int []arr,int length)
	{
		int low=0,mid=0;
		int temp,high = length-1;
		while(mid<=high)
		{
			switch(arr[mid])
			{
			case 0: 
			{
				temp=arr[mid];
				arr[mid]=arr[low];
				arr[low]=temp;
				low++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
				
			case 2:
				
			{
				temp=arr[high];
				arr[high]=arr[mid];
				arr[mid]=temp;
				high--;
				
				break;
				
			}
			}
		}
		
	}
	
	public static void main(String [] args)
	{
		int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}; 
		
		seg(arr,arr.length);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}

}

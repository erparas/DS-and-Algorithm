package misc;

public class TrappingWater {

	public static int calculateWater(int []arr)
	{
		int length = arr.length;
		int []left = new int[length];
		int []right = new int[length];
		left[0]=arr[0];
		right[length-1]=arr[length-1];
		for(int i=1;i<length;i++)
			left[i] = Math.max(left[i-1], arr[i]);
		for(int i=length-2;i>=0;i--)
			right[i]=Math.max(right[i+1], arr[i]);
		int water=0;
		for(int i=0;i<length;i++)
		{
			water+=Math.min(left[i], right[i])-arr[i];
		}
		return water;
		//return 0;
	}
	
	public static void main(String []args)
	{
	
		int []arr= {6,9,9};
		
		int water = calculateWater(arr);
		
		System.out.println(" water is : "+water);
	}
	
	
}

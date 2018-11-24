package array;

public class Seg12 {
	
	public static void seg(int []args,int length)
	{
		int type0=0;
		int type1=length-1;
		int temp;
		while(type0<type1)
		{
			if(args[type0]==1)
			{
				temp=args[type0];
				args[type0]=args[type1];
				args[type1]=temp;
				type1--;
			}
			else type0++;
		}
	}
	
	public static void main(String []args)
	{
		int []arr={0, 1, 0, 1, 1, 1}; 
		//System.out.println(arr.length+":"+arr[0]);
		seg(arr,arr.length);
	//	System.out.println(arr.length+arr[0]);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}

package array;

import java.util.Scanner;

public class Parking {

	public static void main(String []args)
	{
		System.out.println(" Enter number : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int [][]arr = new int[n][2];
		int minStart = Integer.MAX_VALUE;
		int maxEnd = Integer.MIN_VALUE;
		for(int i =0;i<n;i++)
		{
			arr[i][0]=sc.nextInt();
			if(minStart>arr[i][0])
				minStart=arr[i][0];
			arr[i][1]=sc.nextInt();
			if(maxEnd<arr[i][0])
				maxEnd=arr[i][1];	
		}
		System.out.println(" min : "+minStart);
		System.out.println(" max : "+maxEnd);
		int []markers = new int[maxEnd-minStart+1];
		int length = maxEnd-minStart+1;
		System.out.println(" length : "+length);
		int count=0;
		for(int i=0;i<n;i++)
		{
			for(int j = arr[i][0];j<=arr[i][1];j++)
			{
				if(markers[j-minStart]==0)
				{
					markers[j-minStart]=1;
					count++;
				}
			}
		}
		System.out.println(" count : "+count);

	}

}

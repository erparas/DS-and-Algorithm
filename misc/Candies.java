package misc;
import java.util.*;
public class Candies {

	public static void main(String[] args)
	{
		int[] rating = new int[]{ 1,2,2};
		int[] candies = new int[rating.length];
		int length = rating.length;
		for(int i=0;i<length;i++)
			candies[i]=1;
		for(int i =1;i<length;i++)
		{
			if(rating[i]>rating[i-1])
				candies[i] = candies[i]+candies[i-1];
		}
		
		
		for(int j=length-2;j>=0;j--)
		{
			if(rating[j] > rating[j+1] && candies[j]< candies[j+1]+1)
				candies[j] = candies[j+1]+1;
		}
		int sum=0;
		for(int i =0;i<length;i++)
			sum+=candies[i];
		
		System.out.println(" value of sum : "+sum);
	}
	
}

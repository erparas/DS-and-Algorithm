package array;

public class MaxContArray {

	public static void main(String []args)
	{
		//int []arr={-2,-3,4,-1,-2,1,5,-3};
		int []arr={0,1,2,-9,10};
		int maxSoFar=arr[0],maxNow=arr[0];
		int s=0,e=0;
		boolean flag=false;
		for(int i=1;i<arr.length;i++)
		{
			flag=false;
			//maxNow=Math.max(arr[i],maxNow+arr[i]);
			if(arr[i]>(maxNow+arr[i]))
			{
				maxNow=arr[i];
				flag=true;
			}
			else
			{	
				flag=false;
				maxNow=arr[i]+maxNow;
			}
			if(maxSoFar<maxNow)
			{
			maxSoFar=maxNow;
			if(flag==true)
			{
				s=i;
				e=i;
			}
			else 
				e=i;
			}
		}
		System.out.println("Max sum : "+maxSoFar+" , with i : "+s+" and e: "+e);
	}

}

package array;

public class PivotElement {

	public static void main(String[] args)
	{
		int []arr= {5, 1, 4, 3, 6, 8, 10, 7, 9};
		
		int []lmax = new int[arr.length];
		int []rmin = new int[arr.length];
		lmax[0]=Integer.MIN_VALUE;
		rmin[arr.length-1]=Integer.MAX_VALUE;
		for(int i =1;i<arr.length;i++)
		{
			if(arr[i-1]>lmax[i-1])
				lmax[i]=arr[i-1];
			else lmax[i]=lmax[i-1];
			
		}
		for(int i =arr.length-2;i>=0;i--)
		{
			if(arr[i+1]<rmin[i+1])
				rmin[i]=arr[i+1];
			else
				rmin[i]=rmin[i+1];
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.println("lmax[i] : "+lmax[i]+" arr[i] : "+arr[i]+"rmin[i] : "+rmin[i]);
			if(lmax[i]<arr[i] && rmin[i]>arr[i])
				System.out.println(" index : "+i);
		}
				
	}
}

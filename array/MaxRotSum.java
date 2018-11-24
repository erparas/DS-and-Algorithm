package array;

public class MaxRotSum {
	
	public static void main(String[] args)
	{
		//int []arr ={10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		//int []arr ={1,20,2,10};
		int []arr = {3,1,2};
		
		// 1,2,3 : 8
		
		/*sum : 10
		 * 3,1,2
		 * 2,3,1
		 * 1,2,3
		 * 
		 * 1,2,3
		 * 2,3,1
		 * 3,1,2
		 * 
		
		arr = 1,2,3.4
			1*0 + 2*1+3*2+4*3  : 20
		rotar = 4,1,2,3
			4*0 + 1*1+2*2 +3*3 : 14
		rotar = 3,4,1,2
			3*0+4*1+1*2+2*3  : 12
		rotar 2,3,4,1
			2*0+3*1+4*2+1*3 : 14
			
			*/
		
		
		int sumArr=0,mulArr =0;
		int length = arr.length;
		for(int i =0;i<arr.length;i++)
		{
			sumArr+=arr[i];
			mulArr+=i*arr[i];
		}
		System.out.println(" sum :"+sumArr);
		System.out.println(" mulArr :"+mulArr);
		int maxVal = mulArr;
		int tempMax;
		for(int i=1;i<length;i++)
		{
		//	System.out.println(" arr[length-"+i+"]"+arr[length-i]);
			
			mulArr = mulArr + sumArr - length*arr[length-i];
			//System.out.println(" mulArr"+mulArr);
			//System.out.println(" sumArr"+sumArr);
			//System.out.println(" tempMax"+mulArr);
			if(mulArr>maxVal)
				maxVal = mulArr;
			
		}
		System.out.println(" val : "+maxVal);
		
		
	}

}

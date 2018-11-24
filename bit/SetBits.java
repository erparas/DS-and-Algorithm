package bit;

public class SetBits {

	public static void main(String []args)
	{
		int b =15;
		int count=0;
		while(b>0)
		{
			b=b&(b-1);
			count++;
		}
		System.out.println(" value :"+count);
		
		
	}
	
}

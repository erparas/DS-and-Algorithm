package misc;

public class SumDigit {

	public static int length(String str)
	{
		String temp = "";
		int sum=0;
		for(char ch : str.toCharArray())
		{
			if(ch >=48 && ch<=57)
			{
				temp+=ch;
			}
			else
			{
				if(!temp.isEmpty())
				sum+=Integer.parseInt(temp);
				temp="";
			}
		}
		if(!temp.isEmpty())
		sum+=Integer.parseInt(temp);
		return sum;
	}
	
	public static void main(String[] args)
	{
		String p = "12abc20yz68";
		int count = length(p);
		System.out.println(" count : "+count);
	}
	
}

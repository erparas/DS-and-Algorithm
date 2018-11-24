package string;

import java.util.ArrayList;

public class Anagram {
	
	public static void main(String []args)
	{
		String p = "abc";
		ArrayList<String> list = new ArrayList<String>();
		
		list = calculate(p);
		for(String res : list)
			System.out.println(res);
	}

	static ArrayList<String>  calculate(String p)
	{
		
		if(p==null)
			return null;
		ArrayList<String> permutations = new ArrayList<String>();
		if(p.length()==0)
		{
			permutations.add("");
			return permutations;
		}
		char first = p.charAt(0);
		String remainder = p.substring(1);
		ArrayList<String> words = calculate(remainder);
		for(String word : words)
		{
			for(int j=0;j<=word.length();j++)
			{
				String s = insertCharAt(word,first,j);
				permutations.add(s);
			}
		}
		return permutations;
		
	}
	static String insertCharAt(String word,char c,int i)
	{
		String start = word.substring(0,i);
		String end = word.substring(i);
		return start+c+end;
	}

}

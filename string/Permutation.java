package string;

public class Permutation {

	static void permutation(String str) {
		 permutation(str, "");
		 }

	static	 void permutation(String str, String prefix) {
		 if (str.length() == 0) {
		 System.out.print(prefix+" ");
		 } else {
		 for (int i= 0; i < str.length(); i++) {
		 String rem = str.substring(0, i) + str.substring(i + 1);
		 //System.out.println("rem : "+rem+"      str.substring(0, i)"+str.substring(0, i)+"   str.substring(i + 1)"+str.substring(i + 1));
		 
		// System.out.println("prefix + str.charAt(i)   "+prefix + str.charAt(i));
		 permutation(rem, prefix + str.charAt(i));
		 }
		 }
		 } 
		 
		 public static void main(String[] args)
		 {
			 String t = "abc";
			 //t.substring(0, 0);
			// System.out.println(t);
			 permutation(t);
		 }
}

/*cc150 1.8
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (e.g., "waterbottle" is a rotation of "erbottlewat").
 * */
public class CheckRotation {

	public static void main(String[] args) {
		String x = "hello";
		String y = "llohe";
		System.out.println("The result is: " + checkRotation(x,y));
		

	}

	/*check whether x is the rotation of y*/
	public static boolean checkRotation(String x, String y){
		if (x.length() != y.length()) // length is different.
			return false;
		if (y.contains(x))         // same -> true
			return true;
	    char temp;
		int N = x.length();
		for ( int i = 0; i < N; i++){
			temp = x.charAt(0);
			x = x.substring(1) + temp;
			
			if (y.contains(x))
				return true;
		}
		return false;
	}
}

//cc150-1.1 Implement an algorithm to determine if a string has all unique characters. 
//What if you cannot use additional data structures.

//Complexity: N * N
public class UniqueCharacter {

	public static void main(String[] args) {
		String str = "Hlelo";
		boolean test = test(str);
		System.out.println("Does the String: " + str + " has repeated characters? " + test);

	}
	
	static boolean test(String x){
		int len = x.length();
		int count = 0;
		for (int i = 0; i < len; i++){
			if (count == 1) return true;
			if (x.indexOf(x.charAt(i)) != x.lastIndexOf(x.charAt(i)))
				count =1;
			    return true;
		}
		return false;
		
		/* other method: sort the array first, then get the answer with Complexity N*/
	}

}

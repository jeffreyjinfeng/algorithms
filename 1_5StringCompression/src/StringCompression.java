/*cc150 1.5
 * Implement a method to perform basic string compression using the counts of repeated characters,
 * For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" string
 * would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only upper and lower case letters (a - z).*/
public class StringCompression {

	public static void main(String[] args) {
		String input = "aa";
		System.out.println("Based on the input, the output is: " + stringCompression(input));

	}

	public static String stringCompression(String x){
		int size = x.length();
		StringBuilder y = new StringBuilder();
		int count = 1;
		if (size > 0)
			y.append(x.charAt(0));
		
		if (size == 1) return y.append(count).toString();
		for (int i = 1; i < size; i++){
			if (x.charAt(i) == x.charAt(i - 1 )){
				count++;
				continue;
			}else{
				y.append(count);
				count = 1;
				
				y.append(x.charAt(i));
			}
			
		}
		y.append(count);
	    if (y.length() < size)
			return y.toString();
		else 
			return x;
		
	}
}

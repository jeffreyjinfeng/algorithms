import java.util.ArrayList;
import java.util.List;

/*leetcode: Letter Combinations of a Phone Number 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * */
public class DigitstoLetters {

	public static void main(String[] args) {
		
		String input = "23";
		List<String> ls = letterCombinations(input);
		for (String x: ls) {
			System.out.println(x);
		}
		
	}

	 public static List<String> letterCombinations(String digits) {
		 List<String> ls = new ArrayList<String>();
		 int length = digits.length();
		 if (length == 0) return ls;
		 
		 
		 for (int i = 0; i < length; i++) {
			 ls = addaDigit(ls, digits.charAt(i));
		 }
		 
		 return ls;
		 
	        
	 }
	 
	 public static List<String> addaDigit(List<String> ls, char ch) {
		 List<String> result = new ArrayList<String>();
		 String temp = "";
		 
		 switch (ch) {
		 case '2': 
			 temp = "abc";
			 break;
		 case '3':	
		 	 temp = "def";
		 	 break;
		 case '4':	
			 temp = "ghi";
			 break;
		 case '5':
			 temp = "jkl";
			 break;
		 case '6':
			 temp = "mno";
			 break;
		 case '7':
			 temp = "pqrs";
			 break;
		 case '8':
			 temp = "tuv";
			 break;
		 case '9':
			 temp = "wxyz";
			 break;
		default: 
			temp = ""; 
		 }
		 if (ls.isEmpty()){
			 for (int i = 0; i < temp.length(); i++) {
				 result.add(temp.substring(i, i + 1));
			 }
		 } else {
			 for (String s: ls) {
				 for (int i = 0; i < temp.length(); i++) {
					 result.add(s.concat(temp.substring(i, i + 1)));
				 }
			 }
		 }

		 
		 return result;
	 }
}

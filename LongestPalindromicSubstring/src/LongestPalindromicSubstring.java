// hint: Dynamic programming 
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("11111111111111111111111111111111111111111111111111111"));

	}

	public static String longestPalindrome(String s) {
        int length = s.length();
        int[][] checkPalindrome = new int[length][length];
        int flag = 0;
        for (int i = 0; i < length; i++) {
        	for (int j = i; j < length; j++) {
        		if (i == j) {
        			checkPalindrome[i][j] = 1;
        			continue;
        		}
        		if (i + 1 == j) {
        			if (s.charAt(i) == s.charAt(j)){
        				checkPalindrome[i][j] = 1;
        				continue;
        			} else {
        				//checkPalindrome[i][j] = 0;
        				continue;
        			}
        		}
        		
        		flag = 0;
        		for (int m = 0; m < (j - i) / 2 + 1; m++){
        			if (s.charAt(i + m) != s.charAt(j - m)) {
        				flag = 1;
        				break;
        			}
        		}
        		
        		if (flag == 0) {
        			checkPalindrome[i][j] = 1;
        		}
        	}
        }
        
        //find the longest one from the checkPalindrome
        int longestLength = 0;
        int indexStart = 0;
        int indexEnd = 0;
        int currentLength = 0;
        for (int i = 0; i < length; i++) {
        	for (int j = i; j < length; j++) {
        		if (checkPalindrome[i][j] == 1) {
        			currentLength = j - i + 1;
        			if (currentLength > longestLength) {
        				longestLength = currentLength;
        				indexStart = i;
        				indexEnd = j;
        			}
        		}
        	}
        }
        
        return s.substring(indexStart, indexEnd + 1);
    }
	
	
}


public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		
		String[] strs = {"aca", "cba"};
		System.out.println(longestCommonPrefix(strs));

	}

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) return "";
        int minimumLength = strs[0].length();
        // get the minimum length of the string array
        for (int i = 0; i < length; i++) {
        	if (strs[i].length() < minimumLength) {
        		minimumLength = strs[i].length();
        	}
        }
        int count = 0;
        char tempChar;
        int flag;
        for (int i = 0; i < minimumLength; i++) {
        	tempChar = strs[0].charAt(i);
        	flag = 1;
        	for (int j = 0; j < length; j++) {
        		if (strs[j].charAt(i) != tempChar) {
        			flag = 0;
        			break;
        		}
        	}
        	if (flag == 1) {
        		count++;
        	} else {
        		break;
        	}
        	
        }
        if (count > 0) {
        	return strs[0].substring(0, count);
        } else {
        	return "";
        }
        
        
    }
}

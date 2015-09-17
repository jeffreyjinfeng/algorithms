
public class ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("ACB", 2));

	}
	
	public static String convert(String s, int nRows) {
		if (nRows <= 0) return null;
		if (nRows >= s.length()) {
			return s;
		}
        if (nRows == 1) {
        	return s;
        }
        String result = "";
        if (nRows == 2) {
        	for (int i = 0; i < s.length(); i++) {
        		if (i % 2 == 0)
        			result = result.concat(Character.toString(s.charAt(i)));
        	}
        	
        	for (int i = 0; i < s.length(); i++) {
        		if (i % 2 == 1)
        			result = result.concat(Character.toString(s.charAt(i)));
        	}
        	
        	return result;
        }
        
        // if nRows >= 3
        int length = s.length();
        for (int i = 0; i < nRows; i++) {
        	if (i == 0) {
        		int increment = nRows * 2 - 2;
        		int current = i;
        		
        		while (current < s.length()) {
        			result = result.concat(Character.toString(s.charAt(current)));
        			current = current + increment;
        		}
        		continue;
        	}
        	
        	if (i == nRows - 1) {
        		int increment = nRows * 2 - 2;
        		int current = nRows - 1;
        		
        		while (current < s.length()) {
        			result =result.concat(Character.toString(s.charAt(current)));
        			current = current + increment;
        		}
        		continue;
        	}
        	
        	int current = i;
        	int distanceToLastRow = nRows - i - 1;
        	int increment = nRows *2 - 2;
        	while (current < s.length()) {
        		result = result.concat(Character.toString(s.charAt(current)));
        		if (current + 2*distanceToLastRow < s.length()) {
        			result = result.concat(Character.toString(s.charAt(current + 2*distanceToLastRow)));
        			current = current + increment;
        		} else {
        			break;
        		}
        	}
        	
        	
        }
        return result;
    }

}

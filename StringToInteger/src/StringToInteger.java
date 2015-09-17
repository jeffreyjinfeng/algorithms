
public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(atoi("77580dfsfsdfs9"));

	}

	
    public static int atoi(String str) {
    	if (str == null) return 0;
        //remove all space at the beginning
    	str = str.trim();
    	if (str.equals("")) return 0;
    	//check the first the character 
    	char first = str.charAt(0);
    	if (Character.isDigit(first) | first == '+' | first == '-') {// + - or numeric
    		if (Character.isDigit(first)) { //numeric
    			int current = 0;
    			int length = str.length();
    			while (current < length && Character.isDigit(str.charAt(current))) {
    				current++;
    			}
    			str = str.substring(0, current);
    			
    		} else {// + -, so check the second bit
    			int current = 1;
    			int length = str.length();
    			while (current < length && Character.isDigit(str.charAt(current))) {
    				current++;
    			}
    			if (current == 1) {
    				return 0;
    			} else {
    				str = str.substring(0, current);
    			}
    			
    		}
    		
    	} else {
    		return 0;
    	}
    	//extract the number
    
    	
    	long target = 0;
    	try {
    		target = Long.parseLong(str);
    	} catch (Exception e) {
    		if (str.charAt(0) == '-') 
    			return Integer.MIN_VALUE;
    		else 
    			return Integer.MAX_VALUE;
    	}
    	
    	// check overflow
    	if (target > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    	if (target < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    	return (int)target;
    	
    }
}

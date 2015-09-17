
public class RegularExpressionMatch {

	public static void main(String[] args) {
		String a = "aa";
		String b = "a*";
		System.out.println(isMatch(a, b));

	}

    public static boolean isMatch(String s, String p) {
        int currentS = 0;
        int lengthS = s.length();
        
        int currentP = 0;
        int lengthP = p.length();
        
        while (currentP < lengthP) {
        	
        	if (currentS >= lengthS)
        		return false;
        	if (p.charAt(currentP) == '.') {
        		currentS++;
        		currentP++;
        		if (currentP < lengthP) {
        			if (p.charAt(currentP) == '*') {
        				int count = 0;
        				while (currentP < lengthP && (p.charAt(currentP) == '.' | p.charAt(currentP) == '*') ) {
        					
        					if (p.charAt(currentP) != '*')
        						count++;
        					currentP++;
        				}
        				if (currentS - 1 + count < lengthS) {
        					currentS = currentS + count;
        					
        					if (currentP < lengthP) {
        						char temp = p.charAt(currentP);
        						int currentTemp = currentS;
        						while (currentTemp < lengthS && s.charAt(currentTemp) != temp) {
        							currentTemp++;
        						}
        						
        						if (currentTemp - 1 < lengthS && s.charAt(currentTemp - 1) == temp) {
        							currentS = currentTemp;
        						} else {
        							return false;
        						}
        					}
        				} else {
        					return false;
        				}
        			}
        				
        		}
        	} else if (p.charAt(currentP) != '*') {//others: not . or *
        		char temp = p.charAt(currentP);
        		if (temp != s.charAt(currentS)) {
        			return false;
        		} else if (currentP + 1 >= lengthP) {//outofbound
        			currentS++;
        			currentP++;
        			break;
        		} else if (p.charAt(currentP + 1) == '.') {
        			currentS++;
        			currentP++;
        		} else if (p.charAt(currentP + 1) != '*') {
        			currentS++;
        			currentP++;
        		} else {// = '*'
        			currentS++;
        			currentP++;
        			
        			int count = 0;
        			while (currentP < lengthP && (p.charAt(currentP) == '.') | p.charAt(currentP) == '*' | p.charAt(currentP) == temp) {
        				if (p.charAt(currentP) != '*') {
        					count++;
        				}
        				currentP++;
        				
        			}
        			
        			System.out.println("currentP should be 2: " + currentP);//test
        			if (currentS - 1 + count < lengthS) {
        				while (count != 0) {
        					if (s.charAt(currentS - 1 ) != temp) {
        						return false;
        					}
        					currentS++;
        					count--;
        				}
        				
        				System.out.println("count should be 0: " + count);//test
        				
        				if (currentP < lengthP) {
        					char temp2 = p.charAt(currentP);
        					int currenttempS = currentS;
        					/*
        					while (s.charAt(currentS) == temp) {
        						currentS++;
        					}
        					
        					if (currentS == lengthS && currentP == lengthP ) {
        						break;
        					}
        					*/
        					
        					while (currenttempS < lengthS && s.charAt(currentS) != temp2) {
        						currenttempS++;
        					}
        					
        					if (currenttempS - 1 < lengthS && s.charAt(currenttempS - 1) == temp2) {
    							currentS = currenttempS;
    						} else {
    							return false;
    						}
        				} else {
        					while (currentS < lengthS && s.charAt(currentS) == temp) {
        						currentS++;
        					}
        				}
        				
        				
        			} else {
        				return false;
        			}
        			
        		}
        	}
        }
        
        if (currentS < lengthS) {
        	return false;
        } else {
        	return true;
        }
    }
}

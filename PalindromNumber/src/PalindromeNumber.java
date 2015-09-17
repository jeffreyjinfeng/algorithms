
public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
        if (x >= 0 && x < 10) 
        	return true;
    	x = Math.abs(x);
    	int NumberOfDigit = (int)Math.log10(x) + 1;
    	
    	int y = x;
    	for (int i = 0; i < NumberOfDigit/2; i++) {
    		if ( x / (int)Math.pow(10, NumberOfDigit - 1) != y % 10) {
    			return false;
    		} else {
    		  x = x - (x / (int)Math.pow(10, NumberOfDigit - 1)) * (int)Math.pow(10, NumberOfDigit - 1);
    		  y = y / 10;
    		  NumberOfDigit--;
    		}
    	}
    	return true;

    }
}

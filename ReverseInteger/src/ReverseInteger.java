


public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * if overflow, return 0. 
	 * Pay attention to the extra 0s.
	 * */
	public int reverse(int input) {
		long reversedNum = 0;

	    long input_long = input;

	    while (input_long != 0)
	    {
	        reversedNum = reversedNum * 10 + input_long % 10;
	        input_long = input_long / 10;
	    }

	    if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
	    {
	        throw new IllegalArgumentException();// or return 0;
	    }
	    return (int)reversedNum;
    }
}


public class Mysqrt {

	public static void main(String[] args) {
		System.out.println(mySqrt(2147483647));

	}

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        return process(x, 1, x);
    }
    
    public static int process(int x, int low, int high) {
    	if (low > high) {
    		System.out.println(low + " " + high);
    	return 0;}
        if (high - low == 1) {
            if ((long)high * (long)high <= (long)x) return high;
            else return low;
        }
        
        if (high == low) return low;

        
        int mid = (int)(((long)low + (long)high) / 2);
        
        if ((long)mid * (long)mid > (long)x)
            return process(x, low, mid - 1);
        else return process(x, mid, high);
    }
    
   
}

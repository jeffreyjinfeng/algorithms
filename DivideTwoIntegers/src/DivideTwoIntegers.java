/*
 * leetcode: Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int value = 0;
        
        while (a > 0) {
            if (a < b) break;
            int count = 0;
            while ((b << count) <= a) {
                count++;
            }
            value = value + (1 << (count- 1));
            a = a - (b << (count - 1));
        } 

        
        // check special situation
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return value;
        else
            return -value;
    }
}

/*
public int divide(int dividend, int divisor) {
    int count = 0;
    while (dividend > 0) {
        dividend = dividend - divisor;
        if (dividend > 0) 
            count++;
    }
    return count;
}

*/
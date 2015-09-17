/*
 * leetcode
 * Strategy: Dynamic Programming
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = -1;
        }
        arr[0] = 1;
        arr[1] = 1;
        return stairsLeft(n, arr);
    }
    
    public int stairsLeft(int n, int[] arr) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        
        // n >= 2
        int a;
        int b;
        if (arr[n] != -1) {
            return arr[n];
        } else {
            if (arr[n - 1] == -1) {
                a = stairsLeft(n - 1, arr);
            } else {
                a = arr[n - 1];
            }
            
            if (arr[n - 2] == -1) {
                b = stairsLeft(n - 2, arr);
            } else {
                b = arr[n - 2];
            }
            arr[n] = a + b;
            return arr[n];
        }
    }
}

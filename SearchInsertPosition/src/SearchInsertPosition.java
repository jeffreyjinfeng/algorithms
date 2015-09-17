/*
 * leetcode: 
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int result;
        
        int i = 0;
        int length = A.length;
        while (i < length && target > A[i]) {
            i++;
        }
        
        return i;
    }
}

/*
 * leetcode: 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1]
 * */
public class SearchforRange {

	public static void main(String[] args) {
		int[] arr = {1, 4};
		arr = searchRange(arr, 4);

	}

    public static int[] searchRange(int[] A, int target) {
        //binary search
        int left = 0;
        int right = A.length - 1;
        int targetIndex = binarySearch(A, left, right, target);
        int[] arr = {-1, -1};
        System.out.println("Index: " + targetIndex);//test
        int rangeLeft;
        int rangeRight;
        int temp;
        if (targetIndex == -1) {
            return arr;
        } else {
            temp = targetIndex;
            while (temp - 1 >= 0 && A[temp - 1] == target) {
                temp--;
            }
            rangeLeft = temp;
            
            temp = targetIndex;
            while (temp + 1 <  A.length && A[temp + 1] == target){
               temp++;
            }
            rangeRight = temp;
            
            arr[0] = rangeLeft;
            arr[1] = rangeRight;
            return arr;
        }
    }
    
    public static int binarySearch(int[] A, int left, int right, int target) {
        if (left == right) {
            if (A[left] == target) 
                return left;
            else
                return -1;
        }
        if (left < right) {
            int middle = (left + right)/2;
            if (A[middle] == target) {return middle;}
            else if (target < A[middle]) {return binarySearch(A, left, middle - 1, target);}
            else {// target > A[middle]
                return binarySearch(A, middle + 1, right, target);
            }
        } else {
            return -1;
        }
    }
}

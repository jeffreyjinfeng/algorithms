/*cc150 11.3
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in the array. You may assume that the array was originally 
 * sorted in increasing order.
 *Example. 
 *Input: find 5 in {15, 16, 19, 20, 25, 1,3,4,5,6}
 *Output: 8 (index of 5)
 * */


/*solution:
 * if target > middle
 *       if target < high   
 *          s(middle+1, high)
 *       else 
 *          s(low, middle)
 * else
 *    if target > low
 *       s(low, middle)
 *    else 
 *        s(middle +1, high)
 * */

package jinfeng;

public class RotatedArray {

	public static void main(String[] args) {
		int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 6, 9, 10};
		int low = 0;
		int high = array.length - 1;
		int target = 5;
		int result = search(array, low, high, target);
		
		System.out.println("the index of " + target + " in the array is: " + result);

	}
	
	public static int search(int[] a, int low, int high, int target){
		
	if (target == a[low]) return low;
	if (target == a[high]) return high;
	int middle = (low + high)/2;
	if (target == a[middle]) return middle;
	
	if (target > a[middle]){
		if (target < high) 
			return search(a, middle + 1, high, target);
		else 
			return search(a, low, middle + 1, target);
	}
		
	else {// target < a[middle]
		if (target > a[low])
			return search(a, low, middle, target);
		else 
			return search(a, middle + 1, high, target);
	}
	
	}

}

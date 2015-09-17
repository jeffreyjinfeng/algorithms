/*solution: QuickSort
 * quicksort uses divide-and-conquer approach
 * we randomly find a pivot in an array, then make elements smaller than the pivot in front of elements 
 * larger than the pivot. Then we get the partition index. Then keep take care of the two subarray.
 * */

package jinfeng;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = {1,5,3,2,1,0};
		quickSort(a, 0, a.length-1);
		for (int i=0; i < a.length; i++){
			System.out.print(a[i]);
		}

	}
	
	public static void quickSort(int[] a, int left, int right){
		int index = partition(a,left,right);
		if (left < index - 1)
			quickSort(a,left,index-1);
		if (index < right)
			quickSort(a,index,right);
	}
	
	public static int partition(int[] a, int left, int right){
		int pivot = a[(left + right)/2];
	    while (left <= right){
	    	while (a[left] < pivot){
				left++;
			}
			while(a[right]>pivot){
				right--;
			}
			
			//swap
			if (left <= right){
				int temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				left++;
				right--;
			}
			
	    }
		return left;
		
	}

}

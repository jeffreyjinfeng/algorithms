/*MergeSort*/
public class MergeSort {

	public static void main(String[] args) {
		int[]a = {1,3,6,9,6,4,3,7,4,8};
		
		mergeSort(a);

		for (int i = 0; i < a.length; i++){
			System.out.print(a[i]);
		}
	}
	
	public static void mergeSort(int[] a){
		int size = a.length;
		int[] helper = new int[size];
		mSort(a, helper, 0, size-1);
	}

	public static void mSort(int[] a, int[] helper, int low, int high){
		int middle = (low + high)/2;
		if (low < high){
			mSort(a,helper,low,middle);
			mSort(a,helper,middle+1,high);
			merge(a,helper,low,middle,high);
		}
	}
	
	/*The merge method is the key to implement the merge sort algorithm.
	 * remember to take care of the remaining in the left.*/
	
	public static void merge(int[]a, int[] helper, int low, int middle, int high){
		for (int i=low; i <= high;i++){
			helper[i] = a[i];
		}
		
		
		int left = low;
		int right = middle+1;
		int current = low;
		while (left <= middle & right <= high){
			if (helper[left] > helper[right]){
				a[current] = helper[right];
				right++;
			}
			else if (helper[left] <= helper[right]){
				a[current] = helper[left];
				left++;
			}
			current++;
		}
		
		int remaining = middle - left; 
		for (int i = 0; i <= remaining; i++){
			a[current + i] = helper[left + i];
		}
		
	}
}

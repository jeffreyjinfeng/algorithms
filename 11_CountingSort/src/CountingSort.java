/*Counting Sort*/
public class CountingSort {

	public static void main(String[] args) {
		int[] a = {5, 4, 3, 5, 6, 8, 6, 7, 10, 12, 11, 6, 5, 13, 10,3,6,7,14};

		//implement counting sort on array a
		
		countingSort(a);
		
		//output sorted array a
		for (int i = 0; i < a.length; i++){
			System.out.print(" "+a[i]);
		}
	}
	
	public static void countingSort(int[] a){
		//count elements in array a, and store counting numbers in a new Array
		int[] count = new int[15]; //given all elements in a are non-negative, the size of count should be a.maxinumbumber+1
		for (int i = 0; i < a.length; i++){
			count[a[i]]++;
		}
		//accumulate array count
		for (int i = 1; i < count.length; i++){
			count[i] = count[i] + count[i - 1];
		}
		
		//copy a to a2, cause finally we have to return modified array a
		int[] a2 = new int[a.length];
		for (int i = 0; i < a2.length; i++){
			a2[i] = a[i];
		}
		
		//output result to a with helper array a2
		for (int i = a2.length - 1; i >= 0; i--){
			count[a2[i]]--;
			a[count[a2[i]]] = a2[i];
		}
	}

}

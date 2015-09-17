
/*cc150 11.1
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end 
 * to hold B. Write a method to merge B into A in sorted order.
 * */
package jinfeng;

public class MergeBToA {

	public static void main(String[] args) {
		int[] a = {3,5,6,0,0,0};
		int[] b = {2,7,8};
		
		sort(a, b, 3, 3);
		
		for (int i = 0; i < 6; i++){
			System.out.print(" "+ a[i]);
		}
		
		

	}
	
	public static void sort(int[] a, int[] b, int sizeA, int sizeB){
		int indexA = sizeA - 1;
		int indexB = sizeB - 1;
		int index = sizeA + sizeB - 1;
		int index2 = index;
		
		while (indexB >= 0){
			if (indexA >= 0 && a[indexA]> b[indexB]){
				a[index] = a[indexA];
				indexA--;
				index--;
			} else {
				a[index] = b[indexB];
				indexB--;
				index--;
			}
		}
	}

}

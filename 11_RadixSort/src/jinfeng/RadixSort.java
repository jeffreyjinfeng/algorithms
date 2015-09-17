/*RadixSort*/
/*reorder according number in every digits*/


package jinfeng;

public class RadixSort {

	public static void main(String[] args) {
		int[] a = {435, 58, 23, 532, 645, 247,343,743,43};
		radixSort(a, 3);//give the largest number of digits
		
		// print sorted array a
		for (int i = 0; i < a.length; i++){
			System.out.print(" " + a[i] );
		}
	}
	
	public static void radixSort(int[] a, int d){
		for (int i = 1; i <= d; i++){
			//get the i digit from the array and form a new array
			int[] digita = new int[a.length];
			for (int j = 0; j < a.length; j++){
				digita[j] = a[j]/(int)Math.pow(10, i - 1) - (a[j]/(int)Math.pow(10, i))*(int)Math.pow(10, 1);
			}
			
			// implement counting sort on digita array
			int[] countdigita = new int[10];
			for (int j = 0; j < digita.length; j++){
				countdigita[digita[j]]++;
			}
			
			System.out.println();
			
			for (int j = 1; j < countdigita.length; j++){
				countdigita[j] = countdigita[j] + countdigita[j - 1];
			}
			
			int[] copydigita = new int[digita.length];
			for (int j = 0; j < copydigita.length; j++){
				copydigita[j] = digita[j];
			}
			
			int[] a2 = new int[a.length];
			for (int j = 0; j < a.length; j++){
				a2[j] = a[j];
			}
			
			for ( int j = digita.length - 1; j >= 0; j--){
				countdigita[copydigita[j]]--;
				//digita[countdigita[copydigita[j]]] = copydigita[j];
				a[countdigita[copydigita[j]]] = a2[j];
				
			}
			
			
			
		}
	}

}

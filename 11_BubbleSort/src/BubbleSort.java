/*Bubble Sort
 * Every loop, move the smallest one to the left.*/
public class BubbleSort {

	public static void main(String[] args) {
		int[] a = {3,2,1,5,7,9,6};
        int size = a.length;
		for (int i = 0; i < size; i++ ){
			for (int j = 0; j < size - 1 - i; j++){
				int temp = a[j];
		        if (a[j] > a[j+1]){//swap
		        	a[j] = a[j+1];
		        	a[j+1] = temp;
		        }
			}
		}
		
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i]);
		}
	}
	
	

}

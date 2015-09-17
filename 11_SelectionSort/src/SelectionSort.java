/*SelectionSort*/
public class SelectionSort {

	public static void main(String[] args) {
		int[] a = {3,2,1,5,7,9,6};
        int size = a.length;
        
        for (int i = 0; i < size - 1; i++){
        	
        	for (int j = i+1; j < size; j++){
        		if (a[j] < a[i]){//swap
        			int temp = a[i];
        			a[i] = a[j];
        			a[j] = temp;
        		}
        	}
        }

        for (int i = 0; i < size; i++){
        	System.out.print(a[i]);
        }
	}

}

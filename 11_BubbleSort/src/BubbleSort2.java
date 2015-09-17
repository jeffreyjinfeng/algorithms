
public class BubbleSort2 {

	public static void main(String[] args) {
		int[] a = {8, 2,1,3,5,4,7,6,0,9};
	    bubbleSort(a);
	    
		for (int x: a){
			System.out.print(x + " ");
		}
	}

	public static void bubbleSort(int[] a){
		int length = a.length;
		for (int i = 0; i < length; i++){
			for (int j = 0; j < length - 1 - i; j++){
				if (a[j] > a[j+1]){
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}

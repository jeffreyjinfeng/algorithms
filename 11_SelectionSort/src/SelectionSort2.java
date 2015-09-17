
public class SelectionSort2 {

	public static void main(String[] args) {
		int[] a = {5,4,6,3,2,7,1,9,8};
		selectionSort(a);
		
		for (int x: a){
			System.out.print(x + " ");
		}
	}

	public static void selectionSort(int[] a){
		int length = a.length;
		
		for (int i = 0; i < length - 1; i++){
			for (int j = i + 1; j < length; j++){
				if (a[j] < a[i]){
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
	}
}

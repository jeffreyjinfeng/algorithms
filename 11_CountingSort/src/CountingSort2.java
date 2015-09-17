
public class CountingSort2 {

	public static void main(String[] args) {
		int[] a ={2, 4, 1, 2, 5,3};
		countingSort(a);
		for (int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		

	}

	public static void countingSort(int[] a){
		int[] b = new int[a.length];
		for (int x: a){
			b[x]++;
		}
		
		for (int i = 1; i < b.length; i++){
			b[i] = b[i - 1] + b[i];
		}
		
		int[] a2 = new int[a.length];
		for (int i = 0; i < a2.length; i++){
			a2[i] = a[i];
		}
		
		for (int i = 0; i < a2.length; i++){
			b[a2[i]]--;
			a[b[a2[i]]] = a2[i];
		}
	}
}

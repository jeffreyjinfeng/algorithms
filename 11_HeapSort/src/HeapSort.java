/*
 * HeapSort
 * @author: Jinfeng Du
 * PS: The binary tree must be complete binary tree
 * 
 * */
public class HeapSort {

	public static void main(String[] args) {
		//create a binary tree, to save time complexity, use array to represent binary tree
        int[] a = {3,4,2,5,12,30,54,25,7,4,2,4,6,4,3,2,7,345,3,2,4,3,4234,5,3};
        
        
        for ( int i = 0; i < a.length; i++){
        	System.out.print(" "+ a[i]);
        }
        
        
        System.out.println();
        
		// implement HeapSort on the binary tree
        heapSort(a);
        
        // print array a to check the result
        for ( int i = 0; i < a.length; i++){
        	System.out.print(" "+ a[i]);
        }
	}
	
	public static void heapSort(int[] a){
		//create a helper array b of a
	    int[] b = new int[a.length];
	   
		for (int i = 0; i < b.length; i++){
			b[i] = a[i];
			
		}
		
		
		
		 int index = 0; // used to move the popped root to array a
		
		while (b.length > 1){
			
			// heapify the binary tree
			heapify(b);
			
			//add the root element to the end of the result array
			a[index]= b[0];
			index++;
			// move the last leaf to the root
			b[0] = b[b.length - 1];
			int[] temp = new int[b.length - 1];
			for (int i = 0; i < temp.length; i++){
				temp[i] = b[i];
			}
			b = temp;
		}
		
		// add the only one element left to the result array
		a[index] = b[0];;
	}

	public static void heapify(int[] b){
		
		
		//iterate from the last incomplete element to node element
		int lastIndex = b.length - 1;
		int lastIncompleteIndex = (lastIndex - 1)/2;
		for (int i = lastIncompleteIndex; i >= 0; i--){
			subheapify(b, i);
		}
		
	}
	
	public static void subheapify(int[] b, int currentIndex){
		
		
		// ps. leftnode = 2*i + 1; rightnode = 2*i + 2
		int left = currentIndex * 2 + 1;
		int right = currentIndex * 2 + 2;
		
		
		if (!(left >= b.length && right >= b.length)){
			
			if (left >= b.length || right >= b.length){
				int tempIndex;
				if (left < b.length) tempIndex = left;
				else tempIndex = right;
				if (b[currentIndex] > b[tempIndex]){
					int tempValue = b[currentIndex];
					b[currentIndex] = b[tempIndex];
					b[tempIndex] = tempValue;
				}
			
				//subheapify(b, tempIndex);
			} else {
				int tempIndex = left;
				if (b[tempIndex] > b[right]){
					tempIndex = right;
				}
				
				
				
				if (b[currentIndex] > b[tempIndex]){
					int tempValue = b[currentIndex];
					b[currentIndex] = b[tempIndex];
					b[tempIndex] = tempValue;
				}
				
				//subheapify(b, left);
				//subheapify(b, right);
			}
		}
	}
}

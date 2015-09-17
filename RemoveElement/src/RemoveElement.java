/*
 * leetcode: Remove Element
 * Remove a certain number in Array A
 * */
public class RemoveElement {
	
    public int removeElement(int[] A, int elem) {
        int current = 0;
        
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (A[i] != elem) {
                A[current] = A[i];
                current++;
            }
        }
        
        return current;
    }
}

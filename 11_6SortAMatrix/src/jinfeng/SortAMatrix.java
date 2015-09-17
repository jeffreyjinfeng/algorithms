/*cc150 11.6
 * Given an M x N matrix in which each row and each column is sorted in ascending order,
 * write a method to find an element
 * */

package jinfeng;

public class SortAMatrix {

	public static void main(String[] args) {
		int[][] a = {{1,5,9,13,17},{2,6,10,14,18},{3,7,11,15,19},{4,8,12,16,20}};
		if (!search(a, 20)){
			System.out.println("target not found");
		}else {
			
		}

	}

	
	public static boolean search(int[][] a, int target){
		
		
		int row = 0;
		int col = a[0].length - 1;
		while (col >= 0 && row < a.length) {
			if (target == a[row][col]){
				System.out.println("Row: "+row+ " Column: " + col);
				return true;
				}
			else if (target < a[row][col]){
				col--;
			}else{// target > a[row][col]
				row++;
			}
		}
		return false;
	}
}

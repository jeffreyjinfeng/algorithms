/*cc150 1.6
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. */
public class RotateMatrix {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		if (checkMatrixSize(arr))
			transpose(arr);
		else 
			System.out.println("not a NxN array");

	}
/*transpose a NxN array*/
	public static int[][] transpose(int x[][]){
		int sizeY = x.length;
		int sizeX = x[0].length;
		int N = sizeY;
		
		int[][] y = new int[sizeY][sizeX];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				y[i][j] = x[N-1-j][i];
		
		//print array y
		for (int i = 0; i < N; i++){
			for (int j = 0; j < N; j++)
				System.out.print(y[i][j] + " ");
			System.out.println();
		}
		return y;
		
	}
	
	/*Check the size of array.
	 * NxN: return true;(N>1)
	 * not NxN: return false;*/
	public static boolean checkMatrixSize(int x[][]){
		int sizeY = x.length;
		int sizeX = x[0].length;
		if (sizeY == sizeX && sizeY != 1)
			return true;
		else return false;
	} 
}

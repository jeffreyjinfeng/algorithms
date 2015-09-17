/*CC150 1.7
 * Write an algorithm such that if an element in an MxN matrix is 0, 
 * its entire row and column are set to 0*/
public class SetZero {

	public static void main(String[] args) {
		int[][] x = {
				{1,2,3,4,5},
				{2,3,4,5,0},
				{3,0,2,5,6},
				{5,4,2,4,6}
		};
		set(x);

	}

	public static int[][] set(int[][] x){
		int sizeX = x[0].length;
		int sizeY = x.length;
		int[][] y = new int[sizeY][sizeX];
		
		for (int i = 0; i < sizeY; i++)
			for ( int j = 0; j < sizeX; j++)
				y[i][j] = x[i][j];
		
		for (int i = 0; i < sizeY; i++){
			for (int j = 0; j < sizeX; j++){
				if (x[i][j] ==0){
					for (int m = 0; m < sizeX; m++)
						y[i][m] = 0;
					for ( int n = 0; n < sizeY; n++)
						y[n][j] = 0;
				}
					 
			}
	
		}
		
		//print
		for (int i = 0; i < sizeY; i++){
			for (int j = 0; j < sizeX; j++){
				System.out.print(y[i][j] + " ");
			}
			System.out.println();
		}
	
		return y;
	}
}

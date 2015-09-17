/*cc150 11.7 unfinished
 * A circus is designing a tower routine consisting of people standing atop one another's
 * shoulders. For practical and aesthetic reasons, each person must be both shorter and lighter
 * than the person below him or her. Given the heights and weights of each person in the circus,
 * write a method to compute the largest possible number of people in such a tower.
 * Example:
 * Input(ht,wt): (65,100) (70,150) (56,90) (75,190) (60,95) (68,110)
 * 
 * Output: The longest tower is length 6 and includes from top to bottom:
 * (56,90) (60,95) (65,100) (68, 110) (70, 150) (75, 190)
 * */

package jinfeng;

public class CircusTower {

	public static void main(String[] args) {
		// input
		int[][] array = {{65,100},{70,150},{56,90},{75,190},{60,95},{68,110}};

	}
	
	public static int builtTower(int[][] a){
		// solution: sort 1st column first, then eliminate the unnormal item based on values at column B
		int rowSize = a.length;
		int colSize = a[0].length;//2
		
		// sort array base on 1st colummn
		
	}

}

import java.util.Scanner;
import java.util.Stack;

/*cc150 3.4
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with disks
 * sorted in ascending order of size from top to bottom (i.e., each disk sits on
 * top of an even large one). You have the following constraints:
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto the next tower.
 * (3) A disk can only be placed on top of a larger disk.
 * Write a program to move the disk from the first tower to the last using stacks.*/
public class TowersOfHanoi {

	/**
	 * @param args
	 */
	public static int N;
	public static Stack<Integer>[] stacks = new Stack[4];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		stacks[1] = new Stack<Integer>();
		stacks[2] = new Stack<Integer>();
		stacks[3] = new Stack<Integer>();
		
		System.out.println("Enter number of disks: ");
		N = in.nextInt();

		
		
		process(N);
		
		in.close();
	}

	 static public void process(int n){
		 for (int i = n; i > 0; i--){
			 stacks[1].push(i);
			}
		 print();
		 move(N, 1, 2, 3);
		
		
	}
	 public static void move(int n, int a, int b, int c){
		 if (n > 0){
			 move(n-1, a, c, b);
			 int x = stacks[a].pop();
			 stacks[c].push(x);
			 print();
			 move(n-1, b, a, c);
		 }
	 }
	 public static void print(){
		 System.out.println("  A  |  B  |  C");
         System.out.println("---------------");
         for(int i = N - 1; i >= 0; i--)
         {
             String d1 = " ", d2 = " ", d3 = " ";
             try
             {
                 d1 = String.valueOf(stacks[1].get(i));
             }
             catch (Exception e){
             }    
             try
             {
                 d2 = String.valueOf(stacks[2].get(i));
             }
             catch(Exception e){
             }
             try
             {
                 d3 = String.valueOf(stacks[3].get(i));
             }
             catch (Exception e){
             }
             System.out.println("  "+d1+"  |  "+d2+"  |  "+d3);
         }
         System.out.println("\n");         
     }
	 
}

import java.util.Stack;

/*cc150 3.6
 * Write a program to sort a stack in ascending order (with biggest items on top.)
 * You may use at most one additional stack to hold items, but you may not copy
 * the elements into any other data structure(such as an array). The stack supports
 * the following operations: push, pop, peek, and isEmpty*/
public class SortStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();
		for (int i = 1; i < 10; i++){
			stack.push(i);
		}
		
		process(stack);

	}
	public static void process(Stack<Integer> a){
		int size = a.size();
		Stack<Integer> result = sort(a, size);
		for (int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
	}

	public static Stack<Integer> sort(Stack<Integer> a, int n){
		if (n == 1) return a;
		else{
		Stack<Integer> b = new Stack();
		
			
			for (int j = 0; j < n - 1; j++){
				
				
			    b.push(a.pop());
				int x = a.pop();
				int y = b.pop();
				//System.out.println("test: x: "+ x +"  y: "+ y);//test
				if (x >= y){
					a.push(y);
					b.push(x);
				}else{
					a.push(x);
					b.push(y);
				}
			}
			while (!b.isEmpty()){
				a.push(b.pop());
			}
		     return sort(a, n-1);
		    }
		
}
	
}

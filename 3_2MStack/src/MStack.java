/*cc150 3.2
 * How would you design a stack which, in addition to push and pop, also has a function min which returns the 
 * minimum element? Push, pop and min should all operate in O(1) time.*/
public class MStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MStack stack = new MStack();
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(5);
		System.out.println(stack.min().data);

	}

	
	Node top;
	Node min = new Node((int)Double.POSITIVE_INFINITY); //store minimum item
	Object pop() {
		if (top != null){
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	void push(int item){
		Node t = new Node(item);
		t.next = top;
		top = t;
		
		// update min
		
		if (top.data < min.data){
			min = top;
		}
		
	}
	
	Object peek(){
		return top.data;
	}
	
	Node min(){
		return min;
	}
}

class Node {
	int data;
	Node next;
	Node(int i){
		this.data = i;
	}
	
	void append(int x) {
		Node n = this;
		while (n.next != null){
			n = n.next;
		}
		n.next = new Node(x);
	}
}
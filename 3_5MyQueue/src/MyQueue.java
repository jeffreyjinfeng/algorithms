import java.util.Stack;

/*cc150 3.5
 * Implement a MyQueue class which implements a queue using two stacks.*/
public class MyQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}

	}

	public static Stack<Integer>[] myQueue = new Stack[2];
	
	MyQueue(){
		myQueue[0] = new Stack<Integer>();
		myQueue[1] = new Stack<Integer>();
	}
	
	public void enqueue(int x){
		myQueue[0].push(x);
	}
	
	public int dequeue(){
		//transfer stack1 to stack2
		while (!myQueue[0].isEmpty()){
			myQueue[1].push(myQueue[0].pop());
		}
		//pop from stack2
		int x = myQueue[1].pop();
		//transfer the rest elements in stack2 to stack1
		while (!myQueue[1].isEmpty()) {
			myQueue[0].push(myQueue[1].pop());
		}
		return x;
	}
	public boolean isEmpty(){
		return myQueue[0].isEmpty();
	}
}

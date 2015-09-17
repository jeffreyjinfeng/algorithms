/*cc150 3.3
 * Image a (literal) stack of plates. If the stack gets too high,
 * it might topple. Therefore, in real life, we would likely start a new stack
 * when the previous stack exceeds some threshold. Implement a data structure 
 * SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should 
 * create a new stack once the previous one exceeds capacity. SetOfStacks.push() and
 * SetOfStacks.pop() should behave identically to a single stack.
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack*/



import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SetOfStacks sos = new SetOfStacks();
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		sos.push(5);
		sos.push(6);
		sos.push(7);
		sos.push(8);
		sos.push(9);
		sos.push(10);
		sos.push(11);
		
		System.out.println(sos.pop());
		System.out.println(sos.pop());
		System.out.println(sos.pop());
		System.out.println(sos.pop());
		System.out.println(sos.pop());
		System.out.println(sos.pop());

	}

	ArrayList<StackwithCapacity> stacks = new ArrayList<StackwithCapacity>();
	public void push(int v){
		StackwithCapacity last = getLastStack();
		if (last != null && !last.isFull()){
			last.push(v);
		}else {
			StackwithCapacity newstack = new StackwithCapacity();
			newstack.push(v);
			stacks.add(newstack);
		}
		
	}
	
	public int pop(){
		StackwithCapacity last = getLastStack();
		int v = (int)last.pop();
		if (last.size() == 0) stacks.remove(stacks.size() - 1);
		return v;
	}
	
	public StackwithCapacity getLastStack(){
		int s = stacks.size();// length of stack
		if (s == 0) return null;
		return stacks.get(s - 1);
	}
}


class StackwithCapacity extends Stack{
	static int SIZE = 5;
	boolean isFull(){
		return super.elementData.length == SIZE;
	}
}
/*cc150 2.7
 * Implement a function to check if a linked list is a palindrome*/
public class Palindrome {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.append(3);
		head.append(2);
		head.append(0);

		System.out.println(checkPalindrome(head));
	}

	static boolean checkPalindrome(Node head){
		int data;
		int data1;
		int data2;
		Stack stack = new Stack();
		Node pointer = head;
		while(pointer != null) {
			data = pointer.data;
			stack.push(data);
			pointer = pointer.next;
		}
		while(head != null){
			data1 = head.data;
			data2 = (int)stack.pop();
			if (data1 != data2) return false;
			head = head.next;
		}
		return true;
			
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


class Stack{
	Node top;
	Object pop() {
		if (top != null){
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	void push(Object item){
		Node t = new Node((int)item);
		t.next = top;
		top = t;
		
		
	}
	
	Object peek(){
		return top.data;
	}
}
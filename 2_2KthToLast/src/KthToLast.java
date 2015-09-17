/*cc150 2.2
 * Implement an algorithm to find the kth to last element of a singly linked list*/
public class KthToLast {

	public static void main(String[] args) {
		Node head = new Node(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		head.appendToTail(7);
		head.appendToTail(8);
		
		System.out.println(kthToLast(8,head));

	}

	public static int kthToLast(int k, Node head){
		if (head == null) return -1;
		if (k > 1){
			int count = 0;
			Node pointer = new Node(0);
			Node pointer2 = pointer;
			pointer.next = head;
			while (pointer.next != null){
				pointer2 = pointer;
				pointer = pointer.next;
				count++;
			}
			if (k == count) return head.data;
			if (k > count) return -1;
			else{// k < count
				pointer2.next = null;
				return kthToLast(k-1,head);
				
			}
		}
		if (k == 1){
			// return the end of linkedlist
			while (head.next!=null){
				head = head.next;
			}
			return head.data;
		}
		return -1;
	}
	
}


class Node {
	Node next = null;
	int data;
	
	public Node(int d){
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
}
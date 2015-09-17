/*cc150 2.3
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 * Example
 * Input: the node c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e*/
public class DeleteNode {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		
		head = head.delete(head, 1);
		
		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}

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
	
	Node delete(Node head, int i){
		Node pointer = head;
		if (head.data == i) head = head.next;
		else {
			while(pointer.next!= null){
				if (pointer.next.data == i){
					pointer.next = pointer.next.next;
					break;
				} else{
					pointer = pointer.next;
				}
			}
		}
		return head;
	}
	
}
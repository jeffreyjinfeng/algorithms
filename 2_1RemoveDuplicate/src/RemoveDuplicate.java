/*cc150 2.1
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 * */
public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(5);
		head.appendToTail(4);
		head.appendToTail(3);
		head.appendToTail(2);
		head.appendToTail(6);
		head.appendToTail(4);
		head.appendToTail(3);
		head.appendToTail(8);

	
		
		
		removeDuplicate(head);
		//print the linkedlist
		
		while (head != null){
			System.out.println(head.data);
			head = head.next;
		}
	}

	
	public static void removeDuplicate(Node head){
		Node pointer1 = head;
		Node pointer2 = head;
		int counter;
		
		while (pointer1 != null){
			counter = 0;
			pointer2 = head;
			
			while (pointer2 != null){
				
				if (pointer2.data == pointer1.data){
					counter++;
					
				}
				pointer2 = pointer2.next;
			}
			
			if (counter > 1){
				for ( int i = 0; i < counter - 1; i++)
					head.deleteNode(head,pointer1.data);
			}
			
			
			pointer1 = pointer1.next;
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
	
	Node deleteNode(Node head, int d){
		Node n = head;
		
		if (n.data == d) {
			return head.next; /*move head*/
			
		}
		while (n.next != null){
			if (n.next.data == d){
				n.next = n.next.next;
				return head; /*head didn't change*/
			}
			n = n.next;
		}
		return head;
	}




}
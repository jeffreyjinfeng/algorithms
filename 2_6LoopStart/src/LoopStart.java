/*cc150 2.6
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * */
public class LoopStart {

	public static void main(String[] args) {
		Node head = new Node(1);
		Node head2 = new Node(2);
		Node head3 = new Node(3);
		Node head4 = new Node(4);
		//form the loop
		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head2;
		
		Node answer = loopstart(head);
		System.out.println(answer.data);
	}

	public static Node loopstart(Node head){
		//make sure there is a loop
		Node pointer1 = head;
		Node pointer2 = head;
		Node loop = null;
		while (pointer1 != null && pointer2 != null){
			pointer1 = pointer1.next;
			pointer2 = pointer2.next.next;
			if (pointer1 == pointer2) {
				loop = pointer1;
				break;
			}
		}
		//find the size of the loop
		Node loopPointer = loop;
		int size = 1;
		
		while(loopPointer.next != loop){
			loopPointer = loopPointer.next;
			size++;
		}
		
		//find the start of the loop
		Node player1 = head;
		Node player2 = head;
		for (int i = 0; i < size; i++)
			player1 = player1.next;
		
		while(player1 != player2){
			player1 = player1.next;
			player2 = player2.next;
		}
		return player1;
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

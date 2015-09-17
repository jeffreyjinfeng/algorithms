/*cc150 2.4
 * Write code to partition a linked list around a value x, 
 * such that all nodes less than x come before all nodes 
 * greater than or equal to x.*/
public class PartitionList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(3);
		head.append(4);
		head.append(2);
		head.append(2);
		
		Node result = partition(head, 3);
		while (result != null){
			System.out.println(result.data);
			result = result.next;
		}
		

	}

	public static Node partition(Node head, int x){
		Node pointer = head;
		Node node1 = new Node(0);
		Node node2 = new Node(0);
		Node pointer1 = node1;
		Node pointer2 = node2;
		
		while (pointer != null) {
			if (pointer.data < x){
				pointer1.next = new Node(pointer.data);
				pointer1 = pointer1.next;
				
			}
			else{
				pointer2.next = new Node(pointer.data);
				pointer2 = pointer2.next;
				
			}
			pointer = pointer.next;
		}
		Node temp = node1;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node2.next;
		return node1.next;
	}
}

class Node{
	int data;
	Node next;
	Node(int i){
		this.data = i;
	}
	
	Node append(int i){
		Node n = this;
		while (n.next != null){
			n = n.next;
		}
		n.next = new Node(i);
		return this;
	}
	
}

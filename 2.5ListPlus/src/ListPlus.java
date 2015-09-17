/*cc150 2.5
 * You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1/s digit is at the head of the list. 
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input:(7->1->6) + (5 -> 9 ->2). That is, 617 + 195.
 * Output: 2->1->9. That is, 912
 * 
 * FOLLOWUP
 * Suppose the digits are stored in forward order. Repeat the above problem.
 * EXAMPLE
 * Input: (6->1->7) + (2->9->5). That is 617 + 295.
 * Output: 9->1->2. That is 912.*/
public class ListPlus {

	public static void main(String[] args) {
		Node nodeA = new Node(7);
		nodeA.append(1);
		nodeA.append(6);
		
		Node nodeB = new Node(5);
		nodeB.append(9);
		nodeB.append(2);
		
		
		/*Node result1 = reverseAdd(nodeA, nodeB);
		
		while (result1 != null){
			System.out.println(result1.data);
			result1 = result1.next;
		}*/
		
	
Node result2 = forwardAdd(nodeA, nodeB);
		
		while (result2 != null){
			System.out.println(result2.data);
			result2 = result2.next;
		}

		
	}
		
		

	
	public static Node reverseAdd(Node nodeA, Node nodeB) {
		Node result = new Node(0);
		int valueA = 0;
		int valueB = 0;
		int extra = 0;
		int value;
		while (nodeA != null || nodeB != null || extra != 0) {
			if (nodeA == null){valueA = 0;}
			else{
				valueA = nodeA.data;
			}
			
			if (nodeB == null){valueB = 0;}
			else{
				valueB = nodeB.data;
			}
			if (valueA + valueB + extra >= 10){
				value = valueA + valueB + extra - 10;
				extra = 1;
			}else{
				value = valueA + valueB + extra;
				extra = 0;
			}
			result.append(value);
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		return result.next;
	}
	
	public static Node forwardAdd(Node nodeA, Node nodeB){
		int value = 0;
		int extra = 0;
		 int valueA = lastDigit(nodeA);
		 int valueB = lastDigit(nodeB);
		 Node temp = null;
		 Node pointer;
		 while(valueA != -1 || valueB != -1 || extra != 0) {
			 if (valueA == -1) valueA = 0;
			 if (valueB == -1) valueB = 0;
			 if (valueA + valueB + extra >= 10) {
				 value = valueA + valueB + extra -10;
				 extra = 1;
			 }else{
				 value = valueA + valueB + extra;
				 extra = 0;
			 }
			 pointer = new Node(value);
			 pointer.next = temp;
			 temp = pointer;
			 
			 valueA = lastDigit(nodeA);
			 valueB = lastDigit(nodeB);
			
			  
		 }
		 return temp;
		
	}
	
	public static int lastDigit(Node head){// remove last node and return last digit
		if (head == null ||head.data == -1) return -1;
		if (head.next == null) {
			int val = head.data;
			head.data = -1;
			return val;
		}
		else {
			Node pointer = head;
			while (pointer.next.next != null) {
				pointer = pointer.next;
			}
			int val = pointer.next.data;
			pointer.next = null;
			return val;
			
		}
		
	}
}

class Node {
	int data;
	Node next;
	Node(int i){
		this.data = i;
	}
	 
	Node append(int i){
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = new Node(i);
		return this;
	}
}
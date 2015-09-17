/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode start = new ListNode(0);
        ListNode previous = start;
        int carrier = 0;
        int a; // store each value at l1
        int b; // store each value at l2
        ListNode current1 = l1; // cursor of l1
        ListNode current2 = l2; // cursor of l2
        while (current1 != null | current2 != null) {
        	if (current1 != null) {
        		a = current1.val;
        		current1 = current1.next;
        	} else {
        		a = 0;
        	}
        	
        	if (current2 != null) {
        		b = current2.val;
        		current2 = current2.next;
        	} else {
        		b = 0;
        	}
        	
        	previous.next = new ListNode((a + b + carrier) % 10);
        	carrier = (a + b + carrier) / 10;
        	previous = previous.next;
        	
        	
        }
        if (carrier == 1) {
            previous.next = new ListNode(1);
        }
        return start.next;
    }
}

class ListNode {
	int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

	      
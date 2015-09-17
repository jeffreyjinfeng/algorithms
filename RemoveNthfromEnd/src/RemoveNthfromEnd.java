
/**
 * 
 * leetcode
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

public class RemoveNthfromEnd {

	public static void main(String[] args) {
		

	}

	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = length(head);
        int diff = length - n;
        
        if (diff == 0) {
            if (head.next == null) return null;
            else return head.next;
        }
        
        
        ListNode before = new ListNode(0);
        before.next = head;
        for (int i = 0; i < diff; i++) {
            before = before.next;
        }
        if (n == 1) {
            before.next = null;
            return head;
        }
        before.next = before.next.next;
        return head;
    }
    
    public static int length(ListNode head) {
        if (head.next == null) return 1;
        else return 1 + length(head.next);
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
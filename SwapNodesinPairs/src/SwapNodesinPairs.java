/*leetcode
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * */

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
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode current = head;
        ListNode before = new ListNode(0);
        ListNode first = before;
        before.next =head;
        
        while (current != null) {
            if (current.next == null) {
                break;
            } else {
                before.next = current.next;
                current.next = current.next.next;
                before.next.next = current;
                before = before.next.next;
                current = before.next;
            }
        }
        return first.next;
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
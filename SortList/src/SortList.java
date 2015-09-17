
public class SortList {

	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head = sortList(head);
		while (head != null) {
			//System.out.println(head.val);
			head = head.next;
		}
	}

	
	
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode beforehead = new ListNode(0);
        beforehead.next = head;
        ListNode current1 = beforehead;
        ListNode current2 = beforehead;
        while (current2.next != null && current2.next.next != null) {
            current1 = current1.next;
            current2 = current2.next.next;
        }
        ListNode head2 = current1.next;
        current1.next = null;

        sortList(head);
        sortList(head2);
        return mergeSortedList(head, head2);
        
    }

    public static ListNode mergeSortedList(ListNode node1, ListNode node2) {
        ListNode before = new ListNode(0);
        ListNode current = before;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                current.next = node1;
                node1 = node1.next;
            }
            else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        while (node1 != null) {
            current.next = node1;
            node1 = node1.next;
            current = current.next;
        }
        while (node2 != null) {
            current.next = node2;
            node2 = node2.next;
            current = current.next;
        }
        current.next = null;
        return before.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
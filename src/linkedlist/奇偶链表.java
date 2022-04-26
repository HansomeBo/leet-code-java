package linkedlist;

import model.ListNode;

public class 奇偶链表 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        /*拆成两个链表，最后再接起来*/
        ListNode pointer = head.next.next;
        ListNode evenHeader = head.next;
        ListNode oddHeader = head;
        ListNode oddTail = oddHeader;
        ListNode evenTail = evenHeader;
        head.next.next = null;
        head.next = null;

        int index = 1;
        while (pointer != null) {
            ListNode tmp = pointer.next;
            pointer.next = null;
            if (index++ % 2 == 1) {
                oddTail.next = pointer;
                oddTail = oddTail.next;
            } else {
                evenTail.next = pointer;
                evenTail = evenTail.next;
            }
            pointer = tmp;
        }
        oddTail.next = evenHeader;
        return oddHeader;
    }
}

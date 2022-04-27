package linkedlist;

import model.ListNode;

/**
 * https://leetcode.cn/problems/partition-list/
 *
 * 分割成两个链表，注意两个链表间分割完可能会相互引用，把他们的尾节点的下一个节点置为空即可
 */
public class 分隔链表 {

    public ListNode partition(ListNode head, int x) {
        ListNode smallTail = new ListNode(0);
        ListNode smallHead = smallTail;
        ListNode bigTail = new ListNode(0);
        ListNode bigHead = bigTail;
        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                bigTail.next = head;
                bigTail = bigTail.next;
            }
            head = head.next;
        }
        bigTail.next = null;
        if (smallHead.next == null) return bigHead.next;
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}

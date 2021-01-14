package linkedlist;

import model.ListNode;

public class 删除链表中多个节点 {

    public static void main(String[] args) {
        System.out.println(removeElements(new ListNode(1, 2, 3, 4, 5, 1, 3, 4, 5, 1, 1), 1));
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode hideNode = new ListNode(-1);
        hideNode.next = head;
        ListNode cur = hideNode;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return hideNode.next;
    }
}

package easy;

import model.ListNode;

public class 反转链表 {

    public static void main(String[] args) {
        System.out.println(reverseList(ListNode.getListNode(new int[]{1, 2, 3, 4, 5, 6})));
    }

    public static ListNode reverseList(ListNode listNode) {
        ListNode cur = listNode;
        ListNode pre = null;
        ListNode head = null;
        while (cur != null) {
            head = new ListNode(cur.val);
            head.next = pre;
            pre = head;
            cur = cur.next;
        }
        return head;
    }
}

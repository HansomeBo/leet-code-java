package linkedlist;

import model.ListNode;

public class 反转链表 {

    public static void main(String[] args) {
        System.out.println(reverseListII(ListNode.getListNode(new int[]{1, 2, 3, 4, 5, 6})));
    }

    public static ListNode reverseList(ListNode listNode) {
        /*新链表的队头和队尾*/
        ListNode head = null;
        while (listNode != null){
            ListNode newHead = new ListNode(listNode.val);
            /*新队头指向老队头*/
            newHead.next = head;
            head = newHead;
            listNode = listNode.next;
        }
        return head;
    }

    public static ListNode reverseListII(ListNode listNode) {

        ListNode newHead = null;
        ListNode cur = listNode;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tmp;
        }

        return newHead;
    }

}

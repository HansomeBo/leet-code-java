package linkedlist;

import model.ListNode;

public class 合并两个有序链表 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListNode(new int[]{1, 3, 5, 7, 8});
        ListNode l2 = ListNode.getListNode(new int[]{2, 4, 6});
        ListNode res = mergeTwoLists(l1, l2);
        System.out.println(res);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        /*方便循环中对head操作，给head和tail一个初始化的值，这个值最后舍弃*/
        head = tail = new ListNode(-1);

        /*比较两个链表，对尾节点进行追加*/
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            tail = tail.next;
        }
        /*将剩余可能没合并完的节点直接追加到链表尾部*/
        tail.next = l1 == null ? l2 : l1;

        /*去掉那个没用的头节点*/
        return head.next;
    }
}

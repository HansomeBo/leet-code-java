package linkedlist;

import model.ListNode;


/**
 * https://leetcode.cn/problems/sort-list/
 * 三个神器：断链、双路合并、dummyHead大法
 * [4,3,1,7,8,9,2,11,5,6].
 * step=1: (3->4)->(1->7)->(8->9)->(2->11)->(5->6)
 * step=2: (1->3->4->7)->(2->8->9->11)->(5->6)
 * step=4: (1->2->3->4->7->8->9->11)->(5->6)
 * step=8: (1->2->3->4->5->6->7->8->9->11)
 */
public class 排序链表 {

    public static ListNode sortList(ListNode head) {
        int length = head.getLength();

        /*自底向上排序*/
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int size = 1; size < length; size *= 2) {
            /*每次合并都将当前节点设置为头节点，头节点每次都会变，所以将头节点设置为dummyHead.next*/
            ListNode current = dummyHead.next;
            /*将为节点设置为dummy，新计算后的头节点跟在dummy节点后边*/
            ListNode tail = dummyHead;
            while (current != null) {
                ListNode left = current;
                /*左边断链*/
                ListNode rigth = cut(left, size);
                /*右边断链*/
                current = cut(rigth, size);

                tail.next = merge(left, rigth);
                /*保持尾节点在最后边*/
                while (tail.next != null) tail = tail.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * cut(l, n)，split 操作，即断链操作。将链表 l 切掉前 n 个节点，并返回后半部分的链表头。
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode cut(ListNode head, int n) {
        if (head == null) return null;
        ListNode current = head;
        for (int i = 0; i < n - 1; i++) {
            current = current.next;
            if (current == null) return null;
        }

        /*后半部分的链表头*/
        ListNode rightHead = current.next;
        /*断链*/
        current.next = null;
        return rightHead;
    }

    /**
     * merge(l1, l2)，双路归并，合并两个有序的链表
     *
     * @param left
     * @param rigth
     * @return
     */
    public static ListNode merge(ListNode left, ListNode rigth) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        while (left != null && rigth != null) {
            if (left.val < rigth.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = rigth;
                rigth = rigth.next;
            }
            current = current.next;
        }
        if (left != null) current.next = left;
        if (rigth != null) current.next = rigth;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getListNode(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
        System.out.println(sortList(head));
    }

}

package linkedlist;

import model.ListNode;

public class 旋转链表 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, 2, 3, 4, 5);

//        ListNode tmp = node;
//        tmp.next.next = null;
//        System.out.println(tmp);
//        System.out.println(node);
        System.out.println(rotateRightII(node, 7));

    }

    /**
     * 先定位到倒数第K个节点，再将这个节点和后续的节点换成队头
     * 有问题，当K>链表长度的时候，需要额外判断，不能这么搞太复杂了
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        /*两个指针*/
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        /*尾部的链表*/
        ListNode hide = new ListNode(-1);
        hide.next = head;
        while (fast != null) {
            fast = fast.next;
            hide = hide.next;
        }
        ListNode newHead = hide.next;
        hide.next = null;
        System.out.println(newHead);
        System.out.println(head);
        ListNode tmp = newHead;
        for (int i = 0; i < k - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = head;
        return newHead;
    }

    public static ListNode rotateRightII(ListNode head, int k) {
        if (head == null) return head;
        /*找到尾节点，顺便计算出链表长度*/
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length ++;
        }
        /*首位相连，形成环*/
        tail.next = head;
        /*找出头节点*/
        int offset = length - k % length;
        System.out.println(offset);
        System.out.println(length);
        for (int j = 0; j < offset - 1; j++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}

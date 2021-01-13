package linkedlist;

import model.ListNode;

public class 链表中倒数第K个节点 {

    public static void main(String[] args) {
        ListNode result = getReciprocalNode(ListNode.getListNode(new int[]{1, 2, 3, 4, 5, 6, 7}), 3);
        System.out.println(result);
    }

    public static ListNode getReciprocalNode(ListNode listNode, int k) {
        ListNode fastNode = listNode;
        /*快指针先移动K个节点*/
        for (int i = 0; i < k; i++) {
            fastNode = fastNode.next;
        }
        /*快慢指针一起移动，直到快指针到链表结尾*/
        while (fastNode != null) {
            listNode = listNode.next;
            fastNode = fastNode.next;
        }
        return listNode;
    }

}

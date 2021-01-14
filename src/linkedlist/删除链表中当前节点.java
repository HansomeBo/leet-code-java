package linkedlist;

import model.ListNode;

public class 删除链表中当前节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,2,3,4);
        ListNode del = head.next;
        deleteNode(del);
        System.out.println(head);
    }

    /**
     *
     * @param node
     */
    public static void deleteNode(ListNode node) {
        /**
         * 因为拿不到原引用，所以不可以用node = node.next;
         */
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

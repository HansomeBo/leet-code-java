package linkedlist;

import model.ListNode;

public class 链表中间节点 {

    public static void main(String[] args) {
        System.out.println(middleNode(new ListNode(1,2,3,4)));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

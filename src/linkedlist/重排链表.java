package linkedlist;

import model.ListNode;

public class 重排链表 {

    public static void main(String[] args) {

    }

    public static void reorderList(ListNode head) {
        if(head == null) return;
        /*找到中点*/
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null){
            pre = slow;
            fast = fast.next;
            slow = slow.next;
            if (fast != null) fast = fast.next;
        }
        /*切成两个链表*/
        pre.next = null;
        /*翻转slow链表*/
        ListNode newHead = null;
        while(slow != null){
            ListNode tmp = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = tmp;
        }
        ListNode pointer = head;
        while(pointer != null && newHead != null){
            ListNode tmp = pointer.next;
            pointer.next = newHead;
            newHead = newHead.next;
            pointer.next.next = tmp;
            pointer = pointer.next.next;
        }
    }
}

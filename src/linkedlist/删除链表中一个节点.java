package linkedlist;

import model.ListNode;

public class 删除链表中一个节点 {

    public static void main(String[] args) {
        System.out.println(deleteNode(new ListNode(1,2,34,4,56,7,9),4));
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if(val == head.val) return head.next;
        ListNode cur = head;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
                return head;
            }
            cur = cur.next;
        }
        return head;
    }

}

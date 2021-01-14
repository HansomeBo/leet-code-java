package linkedlist;

import model.ListNode;

public class 删除链表当中的重复元素_有序 {

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(1,1,2,3,3,4,4,4,5,6,7,8)));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;
        while (pointer != null && pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }

}

package linkedlist;

import model.ListNode;


/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */
public class 删除链表当中的重复元素_有序II {

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(1, 2, 3, 3, 2, 1)));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode hide = new ListNode(-1, head);
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode pre = hide;
        while (fast != null) {
            if (fast.val == slow.val) {
                if (fast.next == null) {
                    pre.next = null;
                    return hide.next;
                }
                fast = fast.next;
            } else if (slow.next == fast) {
                fast = fast.next;
                slow = slow.next;
                pre = pre.next;
            } else {
                pre.next = fast;
                slow = fast;
                fast = fast.next;
            }
        }
        return hide.next;
    }

}

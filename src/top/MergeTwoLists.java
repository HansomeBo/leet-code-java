package top;


import model.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个有序链表
 * 递归
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListNode(new int[]{1, 2, 7, 8, 10});
        ListNode l2 = ListNode.getListNode(new int[]{4, 5, 6, 18});
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            if (l1.val > l2.val) {
                l2.next = mergeTwoLists(l2.next, l1);
                return l2;
            } else {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }
        }
    }

}

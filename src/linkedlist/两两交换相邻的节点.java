package linkedlist;

import model.ListNode;

//https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-91/

/**
 * 想清楚要用几个指针，指针要理清楚
 */
public class 两两交换相邻的节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,2,3,4,5);
        System.out.println(swapPairsII(head));
    }

    /*递归*/
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

    /*迭代，需要一个隐藏的头节点*/
    public static ListNode swapPairsII(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode hide = new ListNode(-1);
        hide.next = head;

        ListNode pre = hide;
        ListNode one = head;
        ListNode tow = one.next;
        while (one != null && tow != null){
            /*交换第一个和第二个指针的位置*/
            one.next = tow.next;
            tow.next = one;
            pre.next = tow;

            /*移动前一个、第一个、第二个指针*/
            pre = pre.next.next;
            one = pre == null ? null : pre.next;
            tow = one == null ? null : one.next;

        }
        return hide.next;
    }
}

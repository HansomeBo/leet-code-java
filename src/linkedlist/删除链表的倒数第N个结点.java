package linkedlist;

import model.ListNode;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 双指针，快慢指针
 *
 */
public class 删除链表的倒数第N个结点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastIndex = head;
        ListNode slowIndex = head;
        for(int i = 0; i < n ; i++){
            if(fastIndex == null) break;
            fastIndex = fastIndex.next;
        }
        if (fastIndex == null) return head.next;
        while(fastIndex.next != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        slowIndex.next = slowIndex.next.next;
        return head;
    }
}

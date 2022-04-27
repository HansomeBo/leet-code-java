package linkedlist;

import model.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * 链表包含头节点的翻转和不包含头节点的翻转不相同，设置一个虚拟节点将这个链表的翻转统一
 * 方便链表的翻转
 */
public class 反转链表II {

    public static void main(String[] args) {
        System.out.println(reverseBetween(new ListNode(3,4),1,2));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        if(left == right) return head;
        ListNode firstTail = dummyNode;
        for(int i = 0; i < left - 1; i++){
            firstTail = firstTail.next;
        }
        ListNode preHead = null;
        ListNode curHead = null;
        ListNode index = firstTail.next;
        if(index == null) return head;
        ListNode secondTail = index;
        for(int j = left; j <= right; j++){
            curHead = index;
            index = index.next;
            curHead.next = preHead;
            preHead = curHead;
        }
        firstTail.next = curHead;
        secondTail.next = index;
        return dummyNode.next;
    }
}

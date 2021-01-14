package linkedlist;

import model.ListNode;

public class 两个链表的第一个公共节点 {

    public static void main(String[] args) {

    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int counter = 0;

        while (pointerA != pointerB && counter < 2) {
            if (pointerA.next == null) {
                pointerA = headB;
                counter ++;
            }else {
                pointerA = pointerA.next;
            }
            if (pointerB.next == null){
                pointerB = headA;
            }else {
                pointerB = pointerB.next;
            }
        }
        if (counter >= 2) return null;
        return pointerA;
    }


}

package linkedlist;

import model.ListNode;

public class 合并两个链表 {

    public static void main(String[] args) {

    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pointer = list1;
        int index = 0;
        ListNode startPointer = null;
        ListNode endPointer = null;
        while(pointer != null){
            if (index == a-1) startPointer = pointer;
            if (index == b+1) {
                endPointer = pointer;
                break;
            }
            pointer = pointer.next;
            index ++;
        }
        startPointer.next = list2;
        pointer = list1;
        while(pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = endPointer;
        return list1;
    }
}

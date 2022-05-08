package linkedlist;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 删除链表当中的重复元素_无序 {

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(new ListNode(1,2,3,3,2,1)));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode pointer = head;
        set.add(head.val);
        while (pointer.next != null) {
            if(set.add(pointer.next.val)){
                pointer = pointer.next;
            }else {
                pointer.next = pointer.next.next;
            }
        }
        return head;
    }

}

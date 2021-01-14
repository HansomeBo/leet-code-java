package linkedlist;

import model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class 回文链表 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, 2, 3, 4, 2, 1);
        System.out.println(isPalindrome(node));
    }

    public static boolean isPalindrome(ListNode head) {
        //找到链表中点，如果链表长度为偶数，则为右侧中点
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        /*翻转后半段链表*/
        ListNode reversalPointer = slowPointer;
        ListNode newHead = null;
        while (reversalPointer != null) {
            ListNode tmp = reversalPointer.next;
            reversalPointer.next = newHead;
            newHead = reversalPointer;
            reversalPointer = tmp;
        }
        /*遍历两个链表*/
        System.out.println(newHead);
        System.out.println(head);
        while (newHead != null && head != null) {
            if (newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindromeII(ListNode head) {

        Deque<Integer> deque = new LinkedList<>();
        ListNode pointer = head;
        while (pointer != null){
            deque.push(pointer.val);
            pointer = pointer.next;
        }

        while (deque.size() > 0){
            if (deque.pop() != head.val) return false;
            head = head.next;
        }

        return true;
    }


}

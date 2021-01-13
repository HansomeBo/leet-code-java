package linkedlist;

import model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class 两数相加II {

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListNode(new int[]{7,2,4,3});
        ListNode l2 = ListNode.getListNode(new int[]{5,6,4});
        System.out.println(addTwoNumbers(l1,l2));
    }

    /*反转链表再进行相加进位*/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = 反转链表.reverseList(l1);
        l2 = 反转链表.reverseList(l2);

        int pop = 0;
        ListNode head = null;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + pop;
            pop = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = head;
            head = tmp;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (pop > 0) {
            ListNode tmp = new ListNode(pop);
            tmp.next = head;
            head = tmp;
        }
        return head;
    }

    /*使用栈*/
    public static ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();
        while (l1 != null){
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            deque2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int pop = 0;
        while (deque1.size() > 0 || deque2.size() > 0){
            int v1 = deque1.size() > 0 ? 0 : deque2.pop();
            int v2 = deque2.size() > 0 ? 0 : deque2.pop();
            int sum = v1 + v2 + pop;
            pop = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = head;
            head = tmp;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (pop > 0) {
            ListNode tmp = new ListNode(pop);
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}

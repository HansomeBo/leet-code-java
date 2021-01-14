package linkedlist;

import model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class 二进制链表转整数 {

    public static void main(String[] args) {
        System.out.println(getDecimalValueII(new ListNode(1, 0, 1)));
    }

    public static int getDecimalValue(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        int index = 0;
        int res = 0;
        while (deque.size() > 0) {
            int bit = deque.pop();
            if (bit == 1) res += Math.pow(2, index);
            index ++;
        }
        return res;
    }

    public static int getDecimalValueII(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}

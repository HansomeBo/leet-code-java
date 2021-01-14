package linkedlist;

import model.ListNode;
import util.PrintUtil;

import java.util.Deque;
import java.util.LinkedList;

public class 从尾到头打印链表 {

    public static void main(String[] args) {
        PrintUtil.printIntArray(reversePrint(new ListNode(1,2,43,4,65,6)));

    }

    public static int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        int count = 0;
        while (head != null){
            deque.push(head.val);
            head = head.next;
            count ++;
        }
        int[] array = new int[count];
        int index = 0;
        while (deque.size() > 0 ){
            array[index ++] = deque.pop();
        }
        return array;
    }


}

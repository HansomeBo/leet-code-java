package linkedlist;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 环路检测 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fastP = head;
        ListNode slowP = head;
        while (fastP != null && fastP.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            /*相遇时，快指针走过的路径是慢指针的两倍*/
            if (fastP == slowP) {
                ListNode newP = head;

                /*此时从头节点和慢指针一起走，相遇的地方就是交点*/
                while (newP != null && slowP != null) {
                    if (newP == slowP) return newP;
                    newP = newP.next;
                    slowP = slowP.next;
                }
            }
            ;
        }
        return null;
    }

    public static ListNode detectCycleII(ListNode head) {
        ListNode curP = head;
        Set<ListNode> set = new HashSet<>();
        while (curP != null) {
            if (set.add(curP)) {
                curP = curP.next;
            }else {
                return curP;
            }
        }
        return curP;
    }

}

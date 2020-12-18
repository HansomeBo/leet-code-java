package easy;

import model.ListNode;

public class 链表中倒数第K个节点 {

    public static void main(String[] args) {
        int k = 1;
        ListNode listNode = ListNode.getListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode tmp = listNode;
//        for (int i = 0; i < k - 1; i++) {
//            tmp = tmp.next;
//        }
        int i = 0;
        while (tmp.next != null) {
            tmp = tmp.next;
            if ( ++i >= k - 1) listNode = listNode.next;
        }
//        listNode = listNode.next;
        System.out.println(listNode.val);
    }

}

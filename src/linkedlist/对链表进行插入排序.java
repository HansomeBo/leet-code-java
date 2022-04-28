package linkedlist;

import model.ListNode;

/**
 * https://leetcode.cn/problems/insertion-sort-list/
 */
public class 对链表进行插入排序 {

    public static ListNode insertionSortList(ListNode head) {
        //创建哑节点，方便在头节点前插入数据
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode first = head;
        ListNode second = head.next;
        while (second != null){
            if(first.val < second.val){
                first = first.next;
                second = second.next;
                continue;
            }else {
                ListNode pre = dummyNode;
                while (pre.next.val < second.val){
                    pre = pre.next;
                }
                first.next = second.next;
                second.next = pre.next;
                pre.next = second;
                second = first.next;
            }

        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        System.out.println(insertionSortList(new ListNode(5,4,3,2,1,6)));
    }
}

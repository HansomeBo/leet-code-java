package easy;


import model.ListNode;

import java.util.ArrayList;
import java.util.List;

/*https://leetcode-cn.com/problems/add-two-numbers/*/
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        List<ListNode> list = new ArrayList<>();
        int plus = 0 ;
        while (tmp1 != null || tmp2 != null || plus > 0){
            int number = (tmp1 == null ? 0 : tmp1.val) + (tmp2 == null ? 0 : tmp2.val) + plus;
            if (number >= 10){
                plus = 1;
            }else {
                plus = 0;
            }
            ListNode node = new ListNode(number%10);
            if (list.size() > 0){
                list.get(list.size() - 1).next = node;
            }
            list.add(node);
            tmp1 = tmp1 == null ? null : tmp1.next;
            tmp2 = tmp2 == null ? null : tmp2.next;

        }
        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode listNode1 = ListNode.getListNode(new int[] {1});
        ListNode listNode2 = ListNode.getListNode(new int[] {9,9});
        System.out.println(listNode1);
        System.out.println(listNode2);
        System.out.println(addTwoNumbers(listNode1,listNode2));
    }
}

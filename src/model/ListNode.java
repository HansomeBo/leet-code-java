package model;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int... arry) {
        if (arry != null) {
            this.val = arry[0];
            this.next = getNextListNode(arry, 1);
        }
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.next == null) {
            return this.val + " ;";
        }
        return this.val + "->" + this.next.toString();
    }

    public static ListNode getListNode(int[] arry) {
        if (arry == null) {
            return null;
        }
        return getNextListNode(arry, 0);
    }

    public static ListNode getNextListNode(int[] arry, int index) {
        if (index >= arry.length) {
            return null;
        }
        ListNode node = new ListNode(arry[index]);
        node.next = getNextListNode(arry, index + 1);
        return node;
    }


}

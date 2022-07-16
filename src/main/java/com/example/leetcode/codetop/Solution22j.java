package com.example.leetcode.codetop;

public class Solution22j {


    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode first = head, sec =head;

        while (k > 0){
            first = first.next;
            --k;
        }

        while (first!=null){
            first = first.next;
            sec = sec.next;
        }

        return sec;
    }

    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);

        Solution22j solution22j = new Solution22j();
        ListNode kthFromEnd = solution22j.getKthFromEnd(listNode1, 2);
        System.out.println(kthFromEnd);
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    ListNode(int x,ListNode next) {
        val = x;
        this.next = next;
    }
}

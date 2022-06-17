package com.example.leetcode.codetop;

public class Solution141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(-4);
        ListNode listNode3 = new ListNode(0);
        listNode3.next = listNode4;
        ListNode listNode2 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode1 = new ListNode(3);
        listNode1.next = listNode2;

        Solution141 solution141 = new Solution141();
        boolean b = solution141.hasCycle(listNode1);

        System.out.println(b);
    }


}

package com.example.leetcode.codetop;

public class Solution83 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(-101, head);
        ListNode cur = dump;
        ListNode next = cur.next;

        while (next != null) {
            if (cur.val != next.val) {
                cur.next = next;
                cur = next;
                next = next.next;
            } else {
                next = next.next;
            }
        }
        cur.next = null;
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(1,listNode1);
        ListNode listNode3 = new ListNode(1,listNode2);

        Solution83 solution83 = new Solution83();
        solution83.deleteDuplicates(listNode3);
        System.out.println();

    }
}

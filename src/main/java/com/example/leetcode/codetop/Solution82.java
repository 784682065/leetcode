package com.example.leetcode.codetop;

public class Solution82 {

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
        if (head == null) {
            return head;
        }

        ListNode dump = new ListNode(-1);
        ListNode cur = head, node = dump;

        while (cur != null) {

            int curVal = cur.val;
            ListNode next = cur.next;
            if (next == null || curVal != next.val) {
                node.next = cur;
                node = node.next;
            } else {
                // 找到第一个不一样的就好
                while (next != null && curVal == next.val) {
                    next = next.next;
                }
            }
            cur = next;
        }

        node.next = null;
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(4, null);
        ListNode listNode5 = new ListNode(3, listNode6);
        ListNode listNode4 = new ListNode(2, listNode5);
        ListNode listNode3 = new ListNode(2, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        Solution82 solution82 = new Solution82();
        ListNode listNode = solution82.deleteDuplicates(listNode1);
        System.out.println(listNode);
    }
}

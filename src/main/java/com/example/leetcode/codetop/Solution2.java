package com.example.leetcode.codetop;

public class Solution2 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dump = new ListNode(-1);
        ListNode res = dump;
        int val1, val2, sum, ys, jw = 0;
        while (l1 != null || l2 != null) {
            val1 = (l1 != null ? l1.val : 0);
            val2 = (l2 != null ? l2.val : 0);
            sum = val1 + val2 + jw;
            ys = sum % 10;
            res.next = new ListNode(ys);
            jw = sum / 10;
            res = res.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (jw != 0) {
            res.next = new ListNode(jw);
        }


        return dump.next;
    }

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(9);
        ListNode listNode2 = new ListNode(9, listNode3);
        ListNode listNode1 = new ListNode(9, listNode2);

//        ListNode listNode6  = new ListNode(7);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode4 = new ListNode(9, listNode5);

        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.addTwoNumbers(listNode1, listNode4);
        System.out.println(listNode);

    }
}

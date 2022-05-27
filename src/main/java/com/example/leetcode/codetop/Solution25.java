package com.example.leetcode.codetop;

/**
 * @author: hzp
 * @date: 2022/5/26
 * @description:
 */
public class Solution25 {

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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dump = new ListNode(-1, head);
        ListNode slow = dump;
        ListNode pre = dump;

        while (true){
            slow = slow.next;
            ListNode fast = slow;

            for (int i = 1; i < k; i++) {
                if (fast!=null)
                    fast =fast.next;
            }

            if (fast == null)
                return dump.next;

            // 找到了那段距离了,从slow 开始交换
            // 1. pre --> slow -->next --.......--->fast --> ......
            // pre --> node -->slow --> next --.......--->fast --> ......
            while (pre.next != fast){
                ListNode next =  slow.next;
                slow.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = slow;
        }
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode listNode7 = new ListNode(7);
        ListNode listNode6 = new ListNode(6,listNode7);
        ListNode listNode5 = new ListNode(5,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);

        ListNode listNode = solution25.reverseKGroup(listNode1, 1);
        System.out.println(listNode);
    }

}

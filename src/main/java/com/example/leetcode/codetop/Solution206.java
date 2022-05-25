package com.example.leetcode.codetop;

/**
 * @author: hzp
 * @date: 2022/5/20
 * @description:
 */
public class Solution206 {
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

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode dump = null;
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;
            // node 节点指向 dump
            node.next = dump;
            //next 节点变成node节点
            dump = node;
            node = next;
        }
        return dump;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        Solution206 solution206 = new Solution206();
        ListNode listNode = solution206.reverseList(listNode1);
        System.out.println(listNode);

    }
}

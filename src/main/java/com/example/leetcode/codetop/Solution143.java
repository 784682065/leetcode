package com.example.leetcode.codetop;

import java.util.LinkedList;
import java.util.Stack;

public class Solution143 {


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

    public void reorderList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        int len = 0;
        ListNode copy = head;
        ListNode dump = new ListNode(-1, head);
        while (copy != null) {
            len++;
            stack.push(copy);
            copy = copy.next;

        }
        ListNode pop = new ListNode();
        for (int i = 0; i < len / 2; i++) {
            pop = stack.pop();
            ListNode tmp = head.next;
            head.next = pop;
            pop.next = tmp;

            head = tmp;
        }

        if (len % 2 == 1) {
            pop = stack.pop();
        }
        pop.next = null;
        head = dump.next;
    }

    public static void main(String[] args) {
//        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        Solution143 solution143 = new Solution143();
        solution143.reorderList(listNode1);
        System.out.println(listNode1);
    }
}

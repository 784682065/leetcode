package com.example.leetcode.solution;

import java.util.Stack;

/**
 * @author: hzp
 * @date: 2022/4/4
 * @description:
 */
public class Solution92 {


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


    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode res = head;
        ListNode beginHead = null, endTail = null;
        int i = 1;
        while (null != head) {
            if (i == left) {
                break;
            }
            beginHead = head;
            head = head.next;
            i++;
        }
        Stack<ListNode> stack = new Stack<>();
        while (null != head) {
            stack.push(head);
            if (i == right) {
                if (head.next != null)
                    endTail = head.next;
                break;
            }
            head = head.next;
            i++;
        }
        if (beginHead == null) {
            beginHead = stack.pop();
            res = beginHead;
        }
        // 开始头指向末尾
        ListNode pop;
        while (!stack.isEmpty()) {
            pop = stack.pop();
            beginHead.next = pop;
            beginHead = beginHead.next;
        }
        beginHead.next = endTail;
        return res;
    }


    public static void main(String[] args) {

        Solution92 solution92 = new Solution92();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
        ListNode res = solution92.reverseBetween(listNode, 1, 2);
        System.out.println(res);
    }
}

package com.example.leetcode.codetop;

import java.util.Stack;

public class Solution234 {

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

    public boolean isPalindrome(ListNode head) {


        ListNode dump = new ListNode(-1, head);
        ListNode slow = dump, fast = dump;
        Stack<Integer> stack = new Stack<>();

        while (null != fast  && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.add(slow.val);
        }

        if (fast == null) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            slow = slow.next;
            if (stack.pop() != slow.val){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(1);
        ListNode listNode4 = new ListNode(2,listNode5);
//        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode4);
        ListNode listNode1 = new ListNode(1,listNode2);

        Solution234 solution234 = new Solution234();
        System.out.println(solution234.isPalindrome(listNode1));
    }
}

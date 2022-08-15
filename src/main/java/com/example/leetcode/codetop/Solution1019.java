package com.example.leetcode.codetop;

import java.util.*;

public class Solution1019 {

      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        //链表元素存储到集合中
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        int[] ans = new int[n];
        // 栈存放 list的index
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            Integer cur = list.get(i);
            while (!stack.isEmpty() && cur > list.get(stack.peek())){
                Integer index = stack.pop();
                ans[index] = cur;
            }
            // 每个index 都要进栈,方便后面对比
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
//         [1,7,5,1,9,2,5,1]
        ListNode listNode8 = new ListNode(1);
        ListNode listNode7 = new ListNode(5,listNode8);
        ListNode listNode6 = new ListNode(2,listNode7);
        ListNode listNode5 = new ListNode(9,listNode6);
        ListNode listNode4 = new ListNode(1,listNode5);
        ListNode listNode3 = new ListNode(5,listNode4);
        ListNode listNode2 = new ListNode(7,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);

        Solution1019 solution1019 = new Solution1019();
        System.out.println(Arrays.toString(solution1019.nextLargerNodes(listNode1)));

    }
}

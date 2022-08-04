package com.example.leetcode.codetop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution32 {


    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 每次 )入栈的时候都会pop 出去一个,无论是( 还是 )
                // 这样会使得栈中即使遇到一连串的 )))))),始终只存在一个 )
                // 这个题的主要就是 如果没有 ( , 那么 ) 就应该被抛弃
                // 使用-1 是处理边界问题,让代码好写
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidParenthesesDP(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // i - dp[i - 1] 表示还剩下几个元素,除去已经连成线的括号
                    // 要是s.charAt(i - dp[i - 1] - 1) 的值是 '(' 则还能加

                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }



    public static void main(String[] args) {
        String s = "())))))";
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses(s));

    }


}

package com.example.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution402 {


    public String removeKdigits(String num, int k) {

        // 从第一位开始 比第一位大的就要移除,  如果比第一位小就留下
        if (num.length() == k){
            return "0";
        }

        StringBuilder res = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            int charAt = num.charAt(i) - '0';
            while (!stack.isEmpty() && charAt < stack.peekLast() && k > 0) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(charAt);
        }

        while (!stack.isEmpty() && stack.peekFirst() == 0) {
            stack.pollFirst();
        }

        while (!stack.isEmpty() && stack.size() > k) {
            res.append(stack.pollFirst());
        }


        return res.toString().isEmpty() ? "0" : res.toString();
    }

    public static void main(String[] args) {
        String arr = "10200";
        Solution402 solution402 = new Solution402();
        System.out.println(solution402.removeKdigits(arr, 1));
    }
}

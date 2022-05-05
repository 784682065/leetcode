package com.example.leetcode.solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: hzp
 * @date: 2022/5/5
 * @description:
 */
public class Solution151 {

    public String reverseWords(String s) {

        int length = s.length();
        Stack<String> stack = new Stack<>();
        StringBuffer subtitle = new StringBuffer();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' '){
                if (! subtitle.toString().isEmpty()){
                    stack.add(subtitle.toString());
                    subtitle = new StringBuffer();
                }
            }else {
                subtitle.append(c);
            }
        }

        if (! subtitle.toString().isEmpty()){
            stack.add(subtitle.toString());
        }

        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()){
            res.append(stack.pop());
            res.append(' ');
        }

        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = "  hello world  ";
        Solution151 solution151 = new Solution151();
        String s1 = solution151.reverseWords(s);
        System.out.println(s1);

    }
}

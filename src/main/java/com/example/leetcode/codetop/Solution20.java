package com.example.leetcode.codetop;

import java.util.HashMap;
import java.util.Stack;

public class Solution20 {

    public boolean isValid(String s) {

        if (s.length() % 2 !=0)
            return false;

        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character>  stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                stack.push(c);
            }else {
                // 不然就stack pop 回第一个
                if (stack.isEmpty() || !map.get(stack.pop()).equals(c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String s = "([)]";
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid(s);
        System.out.println(valid);
    }

}

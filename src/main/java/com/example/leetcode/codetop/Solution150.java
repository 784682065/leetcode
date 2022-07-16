package com.example.leetcode.codetop;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution150 {





    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Stack<Integer> numbs = new Stack<>();
//        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (set.contains(token)){
                Integer i1 = numbs.pop();
                Integer i2 = numbs.pop();
//                String pop1 = stack.pop();
//                String pop2 = stack.pop();

                int res;
                switch (token){
                    case "+" :
                        res = i2+i1;
//                        stack.push("(" + pop2 + " + " + pop1 + ")");
                        break;
                    case "-":
                        res = i2-i1;
//                        stack.push("(" + pop2 + " - " + pop1+ ")");
                        break;
                    case "*":
                        res = i2*i1;
//                        stack.push("(" + pop2 + " * " + pop1+ ")");
                        break;
                    case "/":
                        res = i2/i1;
//                        stack.push("(" + pop2 + " / " + pop1+ ")");
                        break;
                    default:
                        res = 0;
                }
                numbs.push(res);

            }else {
                numbs.push(Integer.parseInt(token));
//                stack.push(token);
            }
        }
//        System.out.println(stack.pop());
        return numbs.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Solution150 solution150 = new Solution150();
        int i = solution150.evalRPN(tokens);
        System.out.println(i);

    }
}

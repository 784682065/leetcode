package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution227 {

    public int calculate(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operationStack= new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            switch (charAt) {
                case '+':
                case '-':
                case '*':
                case '/':
                    numStack.push(Integer.parseInt(sb.toString().trim()));
                    if (numStack.size()>1 && operationStack.peek() == '*'){
                        Integer b = numStack.pop();
                        Integer a = numStack.pop();
                        operationStack.pop();
                        numStack.push(a*b);
                    }else if (numStack.size()>1 && operationStack.peek() == '/'){
                        Integer b = numStack.pop();
                        Integer a = numStack.pop();
                        operationStack.pop();
                        numStack.push(a/b);
                    }else if (numStack.size()>1 && operationStack.peek() == '+' && (charAt =='+' || charAt =='-')){
                        Integer b = numStack.pop();
                        Integer a = numStack.pop();
                        operationStack.pop();
                        numStack.push(a+b);
                    }else if (numStack.size()>1 && operationStack.peek() == '-' && (charAt =='+' || charAt =='-')){
                        Integer b = numStack.pop();
                        Integer a = numStack.pop();
                        operationStack.pop();
                        numStack.push(a-b);
                    }
                    operationStack.push(charAt);
                    sb.delete(0, sb.length());
                    break;
                default:
                    sb.append(charAt);
            }
        }
        numStack.push( Integer.parseInt(sb.toString().trim()));
        while(numStack.size()>1 && !operationStack.isEmpty()){
            Integer b = numStack.pop();
            Integer a = numStack.pop();
            Character operation = operationStack.pop();
            if (operation == '*'){
                numStack.push(a*b);
            }
            if (operation == '/'){
                numStack.push(a/b);
            }
            if (operation == '+'){
                numStack.push(a+b);
            }
            if (operation == '-') {
                numStack.push(a - b);
            }
        }
        return numStack.pop();
    }

    public int calculateOF(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 记录这个数字的前一个符号,碰到乘除直接处理, -的话,加入负数
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "1*2-3/4+5*6-7*8+9/10";
        Solution227 solution227 = new Solution227();
        System.out.println(solution227.calculate(s));
    }
}

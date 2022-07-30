package com.example.leetcode.codetop;

import java.util.Stack;

public class MinStack {


    Stack<MinNode> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(new MinNode(val, val));
        } else {
            stack.push(new MinNode(val, Math.min(val, stack.peek().minVal)));
        }

    }

    public void pop() {
        stack.pop();

    }

    public int top() {
        return stack.peek().nodeVal;
    }

    public int getMin() {
        return stack.peek().minVal;
    }

    static class MinNode {
        int nodeVal;
        int minVal;

        public MinNode(int nodeVal, int minVal) {
            this.nodeVal = nodeVal;
            this.minVal = minVal;
        }


        public int getNodeVal() {
            return nodeVal;
        }

        public void setNodeVal(int nodeVal) {
            this.nodeVal = nodeVal;
        }

        public int getMinVal() {
            return minVal;
        }

        public void setMinVal(int minVal) {
            this.minVal = minVal;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        MinStack obj = new MinStack();
        obj.push(-100);
        obj.push(-10);
        obj.push(10);
        obj.push(11);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

}

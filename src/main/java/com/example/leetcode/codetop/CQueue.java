package com.example.leetcode.codetop;

import java.util.Stack;

class CQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public CQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.add(value);
    }

    public int deleteHead() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.isEmpty() ? -1 :stackOut.pop();
    }

}

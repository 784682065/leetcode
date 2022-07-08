package com.example.leetcode.codetop;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stackA;
    Stack<Integer> stackB;

    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {

        while (!stackB.isEmpty()) {
            stackA.push(stackB.pop());
        }
        stackA.push(x);
    }

    public int pop() {

        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }

        return stackB.pop();
    }

    public int peek() {

        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }

        return stackB.peek();
    }

    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false

    }
}


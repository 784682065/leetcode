package com.example.leetcode.solution;

import java.util.Stack;

/**
 * @author: hzp
 * @date: 2022/4/7
 * @description:
 */
public class MyQueue {

    private Stack<Integer> stack0;
    private Stack<Integer> stack1;

    public MyQueue() {
        stack0 = new Stack<>();
        stack1 = new Stack<>();
    }

    public void push(int x) {
        stack0.push(x);
    }

    public int pop() {
        // 可以一直寄存在stack0 中, 直到stack1 为空,再去那边拿数据,因为对面后面进来的数据本来就不用管
        if (stack1.isEmpty()){
            while (!stack0.isEmpty()) {
                stack1.push(stack0.pop());
            }
        }
        return stack1.pop();
    }

    public int peek() {
        if (stack1.isEmpty()){
            while (!stack0.isEmpty()) {
                stack1.push(stack0.pop());
            }
        }
        return stack1.peek();
    }

    public boolean empty() {
        return stack0.isEmpty() && stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek());// return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

}

package com.example.leetcode.bishi.meituan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main7 {


    // 反向操作就好了
    public void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            deque.addFirst(arr[i]);
            op(deque);
//            System.out.println(deque);
        }
        for (int i = 1; i < n; i++) {
            System.out.printf("%d ", deque.pollFirst());
        }
        System.out.printf("%d", deque.pollFirst());
    }
    // 反操作
    static void op(Deque<Integer> deque) {
        deque.addFirst(deque.pollLast());
        deque.addFirst(deque.pollLast());
    }
}

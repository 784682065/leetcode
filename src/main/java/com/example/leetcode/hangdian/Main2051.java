package com.example.leetcode.hangdian;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  19:42 2020/4/18
 * @param:
 */
public class Main2051 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            Stack stack = new Stack();

            while (n != 0) {
                stack.push(n % 2);
                n = n / 2;
            }
            while (!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
        }

        scanner.close();
    }
}

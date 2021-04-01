package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:31 2020/4/18
 * @param:
 */
public class Main2055 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n-- > 0) {
            char c = scanner.next().charAt(0);
            int num = scanner.nextInt();
            System.out.println(transfer(c) + num);
        }
        scanner.close();
    }

    /**
     * A 从65 开始 a从96
     *
     * @param c
     * @return
     */
    public static int transfer(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (int) c - 64;
        } else {
            return -((int) c - 96);
        }
    }
}

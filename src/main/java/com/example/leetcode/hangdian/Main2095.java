package com.example.leetcode.hangdian;


import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 15:39
 */
public class Main2095 {
    /**
     * 利用数论知识:a^b^a=b，答案与n-1个数异或就是可以找出最终答案
     * 一直超时
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result ^= scanner.nextInt();
            }
            System.out.println(result);
        }
    }


}
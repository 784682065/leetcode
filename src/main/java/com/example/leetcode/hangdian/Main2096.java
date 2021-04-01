package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 15:27
 */
public class Main2096 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            for (int k = 1; k <= num; k++) {
                int a = in.nextInt();
                int b = in.nextInt();
                //可能出现a 和b 都很大的事情
                a = a % 100;
                b = b % 100;
                int c = a + b;
                System.out.println(c % 100);
            }
            break;
        }
    }
}

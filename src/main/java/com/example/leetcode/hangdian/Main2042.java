package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  13:53 2020/4/18
 * @param:
 */
public class Main2042 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] shu = new int[31];
        shu[0] = 3;
        for (int i = 1; i < 31; i++) {
            shu[i] = 2 * (shu[i - 1] - 1);
        }
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            System.out.println(shu[n]);
        }
    }
}

package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  11:16 2020/4/18
 * @param:
 */
public class Main2040 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int M = sn.nextInt();
        for (int i = 0; i < M; i++) {
            int A = sn.nextInt();
            int B = sn.nextInt();

            int sumA = 0, sumB = 0;
            for (int j = 1; j < A; j++) {
                if (A % j == 0) {
                    sumA += j;
                }
            }

            for (int k = 1; k < B; k++) {
                if (B % k == 0) {
                    sumB += k;
                }
            }
            if (A == sumB && B == sumA) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sn.close();
    }

}

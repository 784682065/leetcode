package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 14:13
 */
public class Main2086 {

    /**
     * 思路:
     * <p>
     * 1.找规律
     * <p>
     * n=1    2A1=A0+A2-2C1
     * <p>
     * n=2    3A1=2A0+A3-4C1-2C2
     * <p>
     * n=3    4A1=3A0+A4-6C1-4C2-2C3
     * <p>
     * n=4    5A1=4A0+A5-8C1-6C2-4C3-2C4
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            double a0 = scanner.nextDouble();
            double an1 = scanner.nextDouble();

            double sum = n * a0 + an1;
            for (int i = n - 1; i >= 0; i--) {
                sum -= (i+1)*2 * scanner.nextDouble();
            }
            System.out.println(String.format("%.2f",sum/(n+1)));

        }


    }

}

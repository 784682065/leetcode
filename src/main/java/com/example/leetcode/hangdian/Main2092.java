package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 9:22
 */
public class Main2092 {

    /**
     * n + m = x
     * n * m = y
     * n(x-n) = y
     * <p>
     * △ 公式
     * -n^2 + nx -y = 0
     * deta = x^2 - 4( -1 * (-y)) // 大于等于0时有解
     * deta = x^2 -4y
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int sum = in.nextInt();
            int cj = in.nextInt();
            if (sum == 0 && cj == 0) {
                break;
            }
            // b^2 -  4ac
            if (Math.pow(sum, 2) - 4 * cj >= 0) {
                //求根公式    -b + 根号△  = 2a * 解
                double result = -sum + Math.sqrt(Math.pow(sum, 2) - 4 * cj);
                if (result % 2 == 0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }
    }


}

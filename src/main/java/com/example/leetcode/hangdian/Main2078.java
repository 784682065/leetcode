package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 16:17
 */
public class Main2078 {

    /**
     * 在复习完一门课后，他总是挑一门更简单的课进行复习，
     * 而他复习这门课的效率为两门课的难度差的平方,
     * 而复习第一门课的效率为100和这门课的难度差的平方。
     * 根据这句话，总结出规律：第一门直接复习最简单的课，
     * 才能达到最高效率值。所以本题直接找最小值即可。
     */
    static int T;
    static int n, m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        for (int j = 0; j < T; j++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int minn = 100;
            for (int i = 0; i < n; i++) {
                int t = scanner.nextInt();
                minn = Math.min(minn, t);
            }
            System.out.println((100 - minn) * (100 - minn));
        }
    }
}

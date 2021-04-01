package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:27 2020/4/15
 * @param:
 */
public class Main2009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double v = scanner.nextDouble();
            int time = scanner.nextInt();
            double sum = v;
            for (int i = 1; i < time; i++) {
                v = Math.sqrt(v);
                sum = sum + v;
            }
            System.out.printf("%.2f\r\n", sum);
        }
        scanner.close();
    }
}

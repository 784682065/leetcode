package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-15 15:14
 */
public class Main2003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double x = scanner.nextDouble();
            System.out.printf("%.2f\r\n",Math.abs(x));
        }
    }
}

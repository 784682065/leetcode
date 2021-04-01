package com.example.leetcode.hangdian;


import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:55 2020/4/18
 * @param:
 */
public class Main2039 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            double  a = scanner.nextDouble();
            double  b = scanner.nextDouble();
            double  c = scanner.nextDouble();

            //三角形判断
            if (a + b > c && b + c > a && a + c > b) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

}

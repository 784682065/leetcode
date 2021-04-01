package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:47 2020/4/18
 * @param:
 */
public class Main2056 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n1, m1, n2, m2, n3, m3, n4, m4;
        double xl, yl, xs, ys;


        while (scanner.hasNext()) {
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double x3 = scanner.nextDouble();
            double y3 = scanner.nextDouble();
            double x4 = scanner.nextDouble();
            double y4 = scanner.nextDouble();

            n1 = Math.min(x1, x2);
            m1 = Math.min(y1, y2);
            n2 = Math.max(x1, x2);
            m2 = Math.max(y1, y2);
            n3 = Math.min(x3, x4);
            m3 = Math.min(y3, y4);
            n4 = Math.max(x3, x4);
            m4 = Math.max(y3, y4);

            //当一个矩形的小的点比另外一个矩形的大的点值还大，无论x，y，那么 无相交点
            if (n1 > n4 || m1 > m4 || n2 < n3 || m2 < m3) {
                System.out.println("0.00");
            } else {
                // 取 x，y 较小点的较大值 ， 较大点的 较小值
                xl = Math.max(n1, n3);
                yl = Math.max(m1, m3);
                xs = Math.min(n2, n4);
                ys = Math.min(m2, m4);
                double square = Math.abs(xl - xs) * Math.abs(yl - ys);
                System.out.printf("%.2f", square);
                System.out.println();
            }

        }

        scanner.close();
    }
}

package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:49 2020/4/14
 * @param:
 */
public class Main2001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum;
        while (scanner.hasNext()) {
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();

            sum=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
            //保留两位小数 %.2
            System.out.printf("%.2f\n",sum);
        }

    }
}

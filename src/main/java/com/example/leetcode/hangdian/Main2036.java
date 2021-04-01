package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:02 2020/4/18
 * @param:
 */
public class Main2036 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            double[][] points = new double[n][2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    points[i][j] = scanner.nextDouble();
                }
            }

            //0.5 * (x1*y2 - x2*y1)
            double sum = 0;
            double s;
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    s =  (points[i][0] * points[0][1] - points[0][0] * points[i][1]);
                } else {
                    s = (points[i][0] * points[i + 1][1] - points[i+1][0] * points[i][1]);
                }
                sum = sum + s;
            }
            System.out.println(String.format("%.1f", Math.abs(sum/2)));
        }
    }
}

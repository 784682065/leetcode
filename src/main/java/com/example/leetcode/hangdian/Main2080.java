package com.example.leetcode.hangdian;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-21 9:55
 */
public class Main2080 {

    /**
     * Math.toDegrees(Math.atan(y / x)); 算度数的方法
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        DecimalFormat format = new DecimalFormat("0.00");
        while (T != 0) {
            double x1 = in.nextDouble();
            double y1 = in.nextDouble();
            double x2 = in.nextDouble();
            double y2 = in.nextDouble();
            double jj1 = angle(x1, y1);
            double jj2 = angle(x2, y2);


            double result = Math.abs(jj2 - jj1);
            if (result > 180) {
                result = 360 - result;
            }
            System.out.println(format.format(result));
            T--;
        }
    }

    static private double angle(double x, double y) {
        double jj1;
        if (x == 0 && y > 0) {
            jj1 = 90;
        } else if (x == 0 && y < 0) {
            jj1 = 270;
        } else if (y == 0 && x > 0) {
            jj1 = 0;
        } else if (y == 0 && x < 0) {
            jj1 = 180;
        } else if (x < 0 && y > 0 || x < 0 && y < 0) {
            jj1 = 180 + Math.toDegrees(Math.atan(y / x));
        } else if (x > 0 && y < 0) {
            jj1 = 360 + Math.toDegrees(Math.atan(y / x));
        } else {
            jj1 = Math.toDegrees(Math.atan(y / x));
        }
        return jj1;
    }

}

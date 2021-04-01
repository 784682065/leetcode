package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 15:55
 */
public class Main2076 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-->0) {//28993 241   193 19.3
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            if (h>=12) {
                h -= 12;
            }
            //1秒钟算0.1°
            double hc = 1.0*(h*60*60+m*60+s)/12/10;
            double mc = 1.0*(m*60+s)/10;
            double c = Math.abs(hc-mc);
            if (c>180) {
                c = 360-c;
            }
            System.out.println((int)c);
        }
    }
}

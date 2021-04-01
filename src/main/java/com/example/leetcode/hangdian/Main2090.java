package com.example.leetcode.hangdian;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 11:20
 */
public class Main2090 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sum = 0;
        DecimalFormat format = new DecimalFormat("0.0");
        while(in.hasNext()) {
            String str = in.next();
            double num = in.nextDouble();
            double price = in.nextDouble();
            sum+=num*price;
        }
        System.out.println(format.format(sum));
    }
}

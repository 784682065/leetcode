package com.example.leetcode.ttt;

import java.util.Arrays;
import java.util.Scanner;

public class Mainh1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        long[] moneys = new long[m];
        for (int i = 0; i <m; i++) {
            moneys[i] = scanner.nextInt();
        }
        int reversM = scanner.nextInt();
        Arrays.sort(moneys);
        long total  = moneys[0];
        long people = 1, leftM = reversM;
        for (int i = 1; i < m; i++) {
            long cur = moneys[i];
            total += cur;
            long needTotal = cur * (i+1);
            if (needTotal - total <= reversM){
                people = i+1;
                leftM = reversM - needTotal + total;
            }else {
                break;
            }
        }
        System.out.println(people +" " + leftM);
    }
}

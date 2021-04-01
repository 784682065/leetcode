package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  9:19 2020/4/18
 * @param:
 */
public class Main2033 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int AH=  scanner.nextInt();
            int AM=  scanner.nextInt();
            int AS=  scanner.nextInt();
            int BH=  scanner.nextInt();
            int BM=  scanner.nextInt();
            int BS=  scanner.nextInt();

            int RS = (AS + BS) % 60;
            int RM = (AM + BM) % 60 + (AS+ BS)/60;
            int RH = (AH + BH)  + (AM+ BM)/60;

            System.out.println(RH + " " + RM + " " +RS);
        }

    }


}

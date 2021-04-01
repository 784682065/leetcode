package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 14:28
 */
public class Main2085 {

    /**
     * 0微秒：  1,0
     * 1微秒：  1*3 ， 1*1
     * 2微秒    3*3 + 1*2 ， 3*1 + 1*1
     *
     * a[i] = a[i-1] * 3 + b[i-1] *2
     * b[i] = a[i-1] * 1 + b[i-1] *1
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] numHigh = new long[34];
        long[] numLow = new long[34];
        numHigh[0] = 1;
        for (int i = 1; i < numLow.length; i++) {
            numHigh[i] = numHigh[i - 1] * 3 + numLow[i - 1] * 2;
            numLow[i] = numHigh[i - 1] + numLow[i - 1];
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == -1) {
                break;
            }
            System.out.println(numHigh[n] + ", " + numLow[n]);
        }
    }
}

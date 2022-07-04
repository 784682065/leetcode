package com.example.leetcode.huaweitest;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s5 = in.nextLine();
        String[] s6 = s5.split(" ");
        int M = Integer.parseInt(s6[0]);
        int N = Integer.parseInt(s6[1]);

        String s3 = in.nextLine();
        String[] s4 = s3.split(" ");
        int[] channelSize = new int[s4.length];
        for (int i = 0; i < s4.length; i++) {
            channelSize[i] = Integer.parseInt(s4[i]);
        }

        String s0 = in.nextLine();
        String[] s = s0.split(" ");
        int[] packageSize = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            packageSize[i] = Integer.parseInt(s[i]);
        }
        String s1 = in.nextLine();
        String[] s2 = s1.split(" ");
        int[] cost = new int[s2.length];
        for (int i = 0; i < s2.length; i++) {
            cost[i] = Integer.parseInt(s2[i]);
        }

        int res = process(M, N, channelSize, packageSize, cost);
        System.out.println(res);

    }

//    private static int process(int m, int n, int[] channelSize, int[] packageSize, int[] cost) {
//        int res = -1;
//        int[] channel = new int[n];
//        Arrays.sort(channelSize);
//        for (int i = 0; i < m; i++) {
//            int min = -1;
//            for (int j = 0; j < n; j++) {
//                // 如果报小于这个通道则进入
//                if (packageSize[i] <= channelSize[j]) {
//                    if (min == -1) {
//                        min = j;
//                        continue;
//                    }
//                    min = (channel[j] >= channel[min] ? min : j);
//                }
//            }
//            channel[min] += cost[i];
//        }
//        for (int c : channel) {
//            res = Math.max(c, res);
//        }
//        return res;
//    }
        private static int process(int m, int n, int[] channelSize, int[] packageSize, int[] cost) {
        int res = -1;
        int[] channel = new int[n];
        Arrays.sort(channelSize);
        for (int i = 0; i < m; i++) {
            int min = -1;
            for (int j = 0; j < n; j++) {
                // 如果报小于这个通道则进入
                if (packageSize[i] <= channelSize[j]) {
                    if (min == -1) {
                        min = j;
                        continue;
                    }
                    min = (channel[j] >= channel[min] ? min : j);
                }
            }
            channel[min] += cost[i];
        }
        for (int c : channel) {
            res = Math.max(c, res);
        }
        return res;
    }

}

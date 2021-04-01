package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-22 11:23
 */
public class Main2089 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int[] nums = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            String str = String.valueOf(i);
            if (str.contains("4") || str.contains("62")) {
                nums[i] = 1;
            }
        }
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            int sum = m - n + 1;
            for (int i = n; i <= m; i++) {
                if (nums[i] == 1) {
                    sum--;
                }
            }
            System.out.println(sum);
        }
    }


}

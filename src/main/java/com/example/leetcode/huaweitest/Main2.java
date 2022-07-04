package com.example.leetcode.huaweitest;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());

        Scanner in = new Scanner(System.in);

        int target = Integer.parseInt(in.nextLine());
        String s = in.nextLine();

        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
//
        int res = minCost(nums, target);
        System.out.println(res);
    }

    private static Integer minCost(int[] nums, int target) {

        int[] dp = new int[target + 1];
        Arrays.fill(dp, target + 1);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int coin : nums) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
        }

        return dp[target] > target ? -1 : dp[target];
    }
}

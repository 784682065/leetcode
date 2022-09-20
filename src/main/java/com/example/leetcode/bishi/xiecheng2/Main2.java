package com.example.leetcode.bishi.xiecheng2;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++)
                nums[j] = sc.nextInt();

            String s = sc.next();

            int res = findMinDif(nums, s);
            System.out.println(res);
        }
    }

    public static int findMinDif(int[] nums, String s){

        int maxR = Integer.MIN_VALUE, minR = Integer.MAX_VALUE;
        int maxB = Integer.MIN_VALUE, minB = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++){

            if (s.charAt(i) == 'R'){
                maxR = Math.max(maxR, nums[i]);
                minR = Math.min(minR, nums[i]);
            }else {
                maxB = Math.max(maxB, nums[i]);
                minB = Math.min(minB, nums[i]);
            }
        }

        if (maxR >= maxB)
            return maxR - Math.min(minR, minB);
        else
            return Math.max(maxB- minB, maxR - minR);
    }
}

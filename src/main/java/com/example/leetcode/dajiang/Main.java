package com.example.leetcode.dajiang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;

        int nums_size = 0;
        nums_size = in.nextInt();
        int[] nums = new int[nums_size];
        for(int nums_i = 0; nums_i < nums_size; nums_i++) {
            nums[nums_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int k;
        k = Integer.parseInt(in.nextLine().trim());

        res = containsNearbyDuplic(nums, k);
        System.out.println(String.valueOf(res ? 1 : 0));
    }

    public static boolean containsNearbyDuplic(int[] nums, int k) {
        for (int i = 0; i < nums.length-1; i++) {
            int numI = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                int numJ = nums[j];
                if (numI ==numJ && Math.abs(j - i) >=k){
                    return true;
                }
            }
        }
        return false;
    }
}

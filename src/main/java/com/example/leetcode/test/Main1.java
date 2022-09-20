package com.example.leetcode.test;

import java.util.Random;

public class Main1 {

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        String[] split = ip.split("\\.");
        if (split[0].length() == 0 || split[split.length - 1].length() == 0) {
            System.out.println(-1);
            return;
        }
        Long rs = 0L;
        for (int i = 0, j = split.length - 1; i < split.length; j--, i++) {
            if (!isDigit(split[i])) {
                System.out.println(-1);
                return;
            }
            Long intIp = split[i].length() == 0 ? 0 : Long.parseLong(split[i]) << (8 * j);
            if (Long.parseLong(split[i]) > 255) {
                System.out.println(-1);
                return;
            }
            rs = rs | intIp;
        }
        System.out.println(rs);  //281474976710658
    }

    public static boolean isDigit(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    Random random = new Random();

    public int[] quickSort(int[] nums) {

        doSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void doSort(int[] nums, int left, int right) {
        // todo 注意是小于等于
        if (left <= right) {
            int pos = partition(nums, left, right);
            doSort(nums, left, pos - 1);
            doSort(nums, pos + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, right, randomIndex);
        int ptr = left, poivt = nums[right];

        for (int i = left; i <= right; i++) {
            if (nums[i] < poivt) {
                swap(nums, i, ptr++);
            }
        }
        swap(nums, right, ptr);
        return ptr;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

package com.example.leetcode.codetop;

import java.util.Arrays;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] sorted = new int[m + n];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < m + n; i++) {

            if (p1 < m && p2 < n) {
                if (nums2[p2] >= nums1[p1]) {
                    sorted[i] = nums1[p1];
                    ++p1;
                } else {
                    sorted[i] = nums2[p2];
                    ++p2;
                }
                continue;
            }
            //找到p1 或者p2 赋值就好
            if (p1 < m) {
                sorted[i] = nums1[p1];
                p1++;
                continue;
            }

            if (p2 < n) {
                sorted[i] = nums2[p2];
                p2++;
                continue;
            }
        }

        System.arraycopy(sorted, 0, nums1, 0, sorted.length);
    }

    public void r_merge(int[] nums1, int m, int[] nums2, int n) {


        int p1 = m - 1, p2 = n - 1;

        for (int i = m + n -1; i >= 0 ; i--) {
            if (p1 >= 0 && p2 >= 0 ) {
                if (nums2[p2] >= nums1[p1]) {
                    nums1[i] = nums2[p2];
                    --p2;
                } else {
                    nums1[i] = nums1[p1];
                    --p1;
                }
                continue;
            }

            if (p1 >= 0){
                nums1[i] = nums1[p1];
                --p1;
            }

            if (p2 >= 0){
                nums1[i] = nums2[p2];
                --p2;
            }
        }


    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        Solution88 solution88 = new Solution88();
        solution88.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

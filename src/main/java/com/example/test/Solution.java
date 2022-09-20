package com.example.test;

import java.util.Arrays;

public class Solution {
    /**
     * 两个有序的数组合并成一个有序的数组
     */
    public int[] mergeNums(int[] arr1, int[] arr2) {
        //1.kuaipai

        int len1 = arr1.length;
        int len2 = arr2.length;

        int[] res = new int[len1 + len2];

        int i = 0, j = 0, cur = 0;
        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                res[cur++] = arr1[i++];
            } else {
                res[cur++] = arr2[j++];
            }
        }

        if (i == len1) {
            while (j < len2)
                res[cur++] = arr2[j++];
        } else {
            while (i < len1)
                res[cur++] = arr1[i++];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {7, 8, 9};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.mergeNums(arr1, arr2)));
    }

}

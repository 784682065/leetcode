package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2021/9/14
 * @description:
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int num1Len = nums1.length;
        int num2Len = nums2.length;
        int total = num1Len + num2Len;
        if (total == 0) {
            return 0;
        }

        // 赋予初值
        int j = 0; // 初始位置
        int k = 0;
        int minVal;
        int beforeVal = 0;
        if (num1Len == 0){
            minVal = nums2[k];
            k++;
        } else if (num2Len == 0){
            minVal = nums1[j];
            j++;
        }else {
            if (nums1[j] <= nums2[k]){
                minVal = nums1[j];
                j++;
            }else {
                minVal = nums2[k];
                k++;
            }
        }

        for (int i = 1; i < total / 2 + 1; i++) {

            if (j == num1Len) {
                // 单走k
                beforeVal = minVal;
                minVal = nums2[k];
                k++;
                continue;
            }
            if (k == num2Len) {
                // 单走j
                beforeVal = minVal;
                minVal = nums1[j];
                j++;
                continue;
            }

            if (k < num2Len && nums1[j] >= nums2[k]) {
                beforeVal = minVal;
                minVal = nums2[k];
                k++;
            } else if (j < num1Len && nums1[j] < nums2[k]) {
                beforeVal = minVal;
                minVal = nums1[j];
                j++;
            }
        }

        // 偶数中位数是最中间两个数的均值,比如四个数中位数是a[4/2] 和 a[4/2 +1]的均值
        // 奇数中位数是最中间的数, 比如三个数是 a[3/2 +1]
        double res;
        if (total % 2 == 0) {
            res = (double) (beforeVal + minVal) / 2;
        } else {
            res = minVal;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {3};
        int[] nums2 = {-2,-1};

        Solution4 solution4 = new Solution4();
        double medianSortedArrays = solution4.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);


    }
}

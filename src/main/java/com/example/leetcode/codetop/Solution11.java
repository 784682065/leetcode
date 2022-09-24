package com.example.leetcode.codetop;

public class Solution11 {

    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        int left = 0, right = length - 1;
        while (left < right) {
            // right - left 是长度 min(nums[left],nums[right]) 是宽度
            // 若向内 移动短板 ，水槽的短板 min(h[i], h[j]) 可能变大，因此下个水槽的面积 可能增大 。
            // 若向内 移动长板 ，水槽的短板 min(h[i], h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
            max = Math.max(max, (right - left) * Math.min(height[right], height[left]));
            if (height[left] < height[right]) {
                // 小的移动
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

}

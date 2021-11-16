package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * @author: hzp
 * @date: 2021/11/15
 * @description:
 */
public class Solution42 {
    public int trap(int[] height) {


        int start = 0;
        // 找到开始点
        for (int h : height) {
            if (h == 0) {
                start++;
            }else {
                break;
            }
        }

        // height 去除掉最后是0的数
        int end = height.length ;
        for (int i = height.length -1; i >= 0 ; i--) {
            if (height[i] == 0){
                end--;
            }else {
                break;
            }
        }

        // 如果不够裁剪的,则返回0
        if (end <= start){
            return 0;
        }

        int[] nums = Arrays.copyOfRange(height,start,end);

        return calRainNum(nums, 0, 0);
    }

    /**
     *
     */
    private int calRainNum(int[] height, int start, int total) {

        if (start >= height.length - 1) return total;

        int startVal = height[start];
        int end = start;

        // 找end 点

        // 起点数找到第一个比他高的就结束了. 下个起点就可以放到高的那里,继续开始
        for (int i = start + 1; i < height.length; i++) {
            if (startVal <= height[i]) {
                end = i;
                break;
            }
        }
        // 如果找不到比他高的, 则找剩余里面最高的 ,下一个点切换到那里
        if (end == start){
            int max = Integer.MIN_VALUE;
            for (int i = start + 1; i < height.length; i++) {
                int curVal = height[i];
                if (max <= curVal) {
                    max = curVal;
                    end = i;
                }
            }
        }

        int cur = calTotal(height, start, end);

        return calRainNum(height, end, cur + total);
    }

    private int calTotal(int[] height, int start, int end) {

        int min = Math.min(height[start], height[end]);
        int total = 0;
        for (int i = start + 1; i < end; i++) {
            total += min - height[i];
        }
        return total;
    }

    public static void main(String[] args) {

        int[] height = {1,2};

        Solution42 solution42 = new Solution42();

        int trap = solution42.trap(height);
        System.out.println(trap);


    }
}

package com.example.leetcode.solution;

import java.util.Arrays;

public class Solution34 {


    public int[] searchRange(int[] nums, int target) {


        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }

        //二分查找
        int start , end ;
        int low = 0,high = nums.length -1, mid;
        while ( low <= high){


            mid = (low + high )/2;
            if (nums[mid] == target){
                // 往两边扩展
                start = mid;
                end =mid;

                boolean f1 = true,f2 =true;
                while ( f1 || f2){
                    if (start > 0  && nums[start -1] == target){
                        start --;
                    }else {
                        f1 =false;
                    }

                    if (end  < nums.length -1 && nums[end +1] == target){
                        end ++;
                    }else {
                        f2 =false;
                    }
                }
                res = new int[]{start, end};
                return res;
            }

            if (nums[mid] < target){
                low = mid + 1;
            }

            if (nums[mid] > target){
                high = mid - 1;
            }
        }
        return res;
    }

    /**
     * 开始和结束位置，其实我们要找的就是数组中「第一个等于 target 的位置」（记为 leftIdx）
     * 和「第一个大于target 的位置减一」（记为 rightIdx）。
     *
     */
    public int[] searchRangeOfficial(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {

        Solution34 solution34 = new Solution34();
        int[] nums = {2,2};
        int[] ints = solution34.searchRange(nums, 2);
        System.out.println(Arrays.toString(ints));

    }

}

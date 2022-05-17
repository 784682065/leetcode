package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:57 2020/5/3
 * @param:
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        return majorityElement1(nums, 0, nums.length - 1);
    }

    /**
     * 分治法
     */
    public int majorityElement1(int[] nums, int start, int end) {

        //边界值 只有一个元素时候直接返回该元素
        if (start == end) {
            return nums[start];
        }

        //不使用mid = （end + start）/2 防止溢出
        int mid = (end - start) / 2 + start;
        //不然的话 分治
        int left = majorityElement1(nums, start, mid);
        int right = majorityElement1(nums, mid + 1, end);

        //如果左边的数 等于右边的数那则是众数
        if (left == right) {
            return left;
        }
        //若不相等， 则计算左右两边的数谁出现的次数多
        int countLeft = countNumber(nums, start, mid, left);
        int countRight = countNumber(nums, mid + 1, end, right);

        return countLeft > countRight ? left : right;
    }

    private int countNumber(int[] nums, int start, int mid, int number) {

        int count = 0;

        for (int i = start; i <= mid; i++) {
            if (nums[i] == number) {
                count++;
            }
        }
        return count;
    }


    /**
     * 投票证明法
     * 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
     * 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


//    public int majorityElement(int[] nums) {
//
//        Arrays.sort(nums);
//
//        return nums[(nums.length-1)/2];
//    }

}

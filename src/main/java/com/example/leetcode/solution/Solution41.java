package com.example.leetcode.solution;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author: hzp
 * @date: 2021/11/12
 * @description:
 */
public class Solution41 {

    public int firstMissingPositive(int[] nums) {

        int len = nums.length;

        // 如果数组长度是 len , 则排除在[1,len] 之外的数字,设置为MAX_VALUE
        for (int i = 0; i < nums.length; i++) {
            //1 . 把负数全换成max
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = Integer.MAX_VALUE  ;
            }
        }


        // 把 x在[1,len]之内的值 , 对应的 nums[x-1] 设置成 相反数,利用数组下标 记忆该正数是否出现过
        for (int i = 0; i < nums.length; i++) {
            int num=  Math.abs(nums[i]) ;
            if (Math.abs(nums[i]) >=1 && Math.abs(nums[i]) <= len){
                nums[num-1] =  -Math.abs(nums[num-1]) ;
            }
        }ClassLoader

        // 找到第一个不是负数的, 取得其下标为答案
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        // 若是上一步没找到,则说明数组长度为n 里面的数字正好是1 到N
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        Solution41 solution41 = new Solution41();
        System.out.println(solution41.firstMissingPositive(nums));
    }

}

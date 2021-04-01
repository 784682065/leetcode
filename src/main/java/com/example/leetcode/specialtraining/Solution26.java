package com.example.leetcode.specialtraining;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:54 2020/5/14
 * @param:
 */
public class Solution26 {


    public int removeDuplicates(int[] nums) {

        Arrays.sort(nums);

        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                nums[++start] = nums[i];
            }
        }


        return start + 1;
    }
}

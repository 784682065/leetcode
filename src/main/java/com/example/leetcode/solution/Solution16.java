package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  9:08 2020/1/8
 * @param:
 */
public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        int start ,end,res;
        for (int i = 0; i < nums.length; i++) {
            start = i+1; end =nums.length - 1;
            while (start < end){
                res = nums[i]+ nums[start] + nums[end];
                if(Math.abs(target - res) < Math.abs(target - ans) ){
                    ans = res;
                }
                if (res > target){
                    end --;
                }else if (res < target){
                    start ++;
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
//[0,2,1,-3]
//1
       Solution16 solution16 = new Solution16();
       int[] nums = {0,2,1,-3};
        int i = solution16.threeSumClosest(nums, 1);
        System.out.println(i);

    }




}

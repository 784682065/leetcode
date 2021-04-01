package com.example.leetcode.solution;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:50 2020/5/1
 * @param:
 */
public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] ints= {2,3,1,1,4};
        System.out.println(solution55.canJump(ints));
    }


    boolean flag = false;

    public boolean canJump(int[] nums) {

        dfs(nums, 0);
        return flag;
    }

    private void dfs(int[] nums, int index) {

        if (flag) return;
        //成功条件
        if (index == nums.length - 1) {
            flag = true;
            return;
        }
        if (nums[index] == 0) {
            return;
        }

        for (int i = 1; i <= nums[index]; i++) {
            dfs(nums, index + i);
        }
    }

}

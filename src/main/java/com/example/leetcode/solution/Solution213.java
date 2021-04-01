package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-23 16:07
 */
public class Solution213 {


    /**
     * 环状排列意味着第一个房子和最后一个房子中只能选择一个偷窃，因此可以把此环状排列房间问题约化为两个单排排列房间子问题
     * 不能两个都不偷, 因为 nums 里面全为正数,两个房子都不偷的话,总会亏掉一个房子的钱.
     * <p>
     * 在不偷窃第一个房子的情况下（即 nums[1:]nums[1:]），最大金额是 p_1p
     * 1
     * ；
     * 在不偷窃最后一个房子的情况下（即 nums[:n-1]nums[:n−1]），最大金额是 p_2p
     * 2
     * 。
     * 综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)max(p1,p2) 。
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {

        int length = nums.length;
        if (length == 0 ) return 0;
        if (length == 1 ) return nums[0];

        //不偷第一个房子
        int max1 , preMax1 = 0, curMax1 = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax1;
            curMax1 = Math.max(preMax1 + nums[i], curMax1); //选择加不加nums[i]
            preMax1 = temp;
        }
        max1 = Math.max(curMax1, preMax1);

        int max2 , preMax2 = 0, curMax2 = 0;
        for (int i = 0; i < nums.length-1; i++) {
            int temp = curMax2;
            curMax2 = Math.max(preMax2 + nums[i], curMax2);
            preMax2 = temp;
        }
        max2 = Math.max(curMax2, preMax2);

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,1};
        System.out.println(rob(ints));
    }

}

package com.example.leetcode.solution;

import java.util.Arrays;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-23 13:52
 */
public class Solution300 {


    public static void main(String[] args) {
        int[] nums ={1,3,6,7,9,4,10,5,6};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    /**
     * 第 1 步：定义状态
     由于一个子序列一定会以一个数结尾，于是将状态定义成：dp[i] 表示以 nums[i] 结尾的「上升子序列」的长度。注意：这个定义中 nums[i] 必须被选取，且必须是这个子序列的最后一个元素。

     第 2 步：考虑状态转移方程
     遍历到 nums[i] 时，需要把下标 i 之前的所有的数都看一遍；
     只要 nums[i] 严格大于在它位置之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列；
     因此，dp[i] 就等于下标 i 之前严格小于 nums[i] 的状态值的最大者 +1+1。
     语言描述：在下标 i 之前严格小于 nums[i] 的所有状态值中的最大者 + 1+1。

     符号描述：

     dp[i] = \max_{0 \le j < i, nums[j] < nums[i]} {dp[j] + 1}
     dp[i]=
     0≤j<i,nums[j]<nums[i]
     max
     ​
     dp[j]+1

     第 3 步：考虑初始化
     dp[i] = 1，11 个字符显然是长度为 11 的上升子序列。
     第 4 步：考虑输出
     这里要注意，不能返回最后一个状态值；
     还是根据定义，最后一个状态值只是以 nums[len - 1] 结尾的「上升子序列」的长度；
     状态数组 dp 的最大值才是最后要输出的值。
     \max_{1 \le i \le N} dp[i]
     1≤i≤N
     max
     ​
     dp[i]

     第 5 步：考虑状态压缩。
     遍历到一个新数的时候，之前所有的状态值都得保留，因此无法压缩。

     作者：liweiwei1419
     链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public  static int lengthOfLIS(int[] nums) {

        if (nums.length == 0) return 0;
        //初始化状态
        int temp[] = new int[nums.length];
        Arrays.fill(temp, 1);

        //j 是正在处理的一个位置
        for (int j = 1; j < nums.length; j++) {
            //从i到j
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    temp[j] = Math.max(temp[j], temp[i] + 1);
                }
            }
        }

        int max =0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > max) max =temp[i];
        }

        return max;
    }
}

package com.example.leetcode.codetop;


import java.util.HashMap;

public class Solution560 {

    public int subarraySum(int[] nums, int k) {

        int ans = 0;
        int len = nums.length;
        int preSum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        // 需要初值 0, 这样才能保证从[0...i] 的前缀和为目标值会被计算在内
        map.put(0,1);
        for (int i = 1; i <= len; i++) {
            preSum = nums[i-1] + preSum;
            //只需要在往后走的时候判断就好了
            if (map.containsKey(preSum - k)){
                ans +=map.get(preSum - k);
            }
            Integer orDefault = map.getOrDefault(preSum, 0);
            map.put(preSum,++orDefault);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.subarraySum(nums, k));

    }
}

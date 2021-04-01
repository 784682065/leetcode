package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  16:21 2020/1/10
 * @param:
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int ans,k,m ;
        for (int i = 0; i < nums.length-3; i++) {
            if (i>0 && nums[i-1]==nums[i]) continue;
            for (int j = i+1; j < nums.length -2; j++) {
                if (j>i+1 && nums[j-1]== nums[j]) continue;
                k = j+1; m = nums.length-1;
                while (k<m){
                    ans = nums[i]+nums[j] + nums[k]  + nums[m];
                    if (ans < target){
                        k++;
                    }else if (ans > target){
                        m--;
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        res.add(list);
                        while(k<m&&nums[k+1]==nums[k])      //确保nums[c] 改变了
                            k++;
                        while(k<m&&nums[m-1]==nums[m])      //确保nums[d] 改变了
                            m--;
                        k++;
                        m--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = solution18.fourSum(nums, 0);
        System.out.println(lists.toString());
    }

}

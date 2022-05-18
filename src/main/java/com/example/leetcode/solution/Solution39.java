package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:19 2020/1/14
 * @param: 组合总和
 */
public class Solution39 {

    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        //特解
        if (candidates.length == 0) return res;
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, target, tmp, 0 , 0);

        return res;
    }

    /**
     *
     * @param candidates 候选数组
     * @param target 目标值
     * @param tmp  临时数组
     * @param sum 当前和
     * @param start 开始位置用于剪枝
     */
    private void dfs(int[] candidates, int target,
                     List<Integer> tmp,  int sum, int start ) {
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        /**
         *  i == start 剪枝，不然结果有重复集合 [[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]
         */
        for (int i = start; i < candidates.length && sum <= target ; i++) {
            tmp.add(candidates[i]);
            dfs(candidates, target, tmp,sum + candidates[i],i);

            //回溯 在dfs下面 ，而不是上一个if 方法体内
            tmp.remove(tmp.size()  -1 );
        }
    }

    public static void main(String[] args) {


//        Solution39 solution39 = new Solution39();
//        int[] nums = {10,1,2,7,6,1,5};
//        List<List<Integer>> lists = solution39.combinationSum(nums, 8);
//        System.out.println(lists.toString());
    }


}

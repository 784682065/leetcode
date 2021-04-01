package com.example.leetcode.solution;

import java.util.*;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  13:56 2020/1/14
 * @param:
 */
public class Solution40 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        //特解
        if (candidates.length == 0) return res;
        List<Integer> tmp = new ArrayList<>();

        boolean used[] = new boolean[candidates.length];

        Arrays.sort(candidates);

        dfs(candidates, target, tmp, 0 , 0,used);

        return res;
    }

    /**
     *  @param candidates 候选数组
     * @param target 目标值
     * @param tmp  临时数组
     * @param sum 当前和
     * @param start 开始位置用于剪枝
     * @param used 数组的使用
     */
    private void dfs(int[] candidates, int target,
                     List<Integer> tmp, int sum, int start, boolean[] used) {
        if (sum == target) {
//            if (!res.contains(tmp)) {
                res.add(new ArrayList<>(tmp));
//            }
            return;
        }
        /**
         *  i == start 剪枝，不然结果有重复集合 [[2, 2, 3], [2, 3, 2], [3, 2, 2], [7]]
         */
        for (int i = start; i < candidates.length && sum <= target ; i++) {
            if (!used[i]) {

                // 小剪枝 减去重复结果集
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                tmp.add(candidates[i]);
                used[i] = true;

                //必须 i +1 因为每个元素只能用一次
                dfs(candidates, target, tmp,sum + candidates[i],i + 1, used);

                //回溯 在dfs下面 ，而不是上一个if 方法体内
                tmp.remove(tmp.size()  -1 );
                used[i] =false;
                }
        }
    }

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] nums = {1,2,2,2,5};
        List<List<Integer>> lists = solution40.combinationSum2(nums, 5);
        System.out.println(lists.toString());
    }


    private void dfs(int[] candidates, int len, int begin, int residue, Deque<Integer> path, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝 剪掉不符合结果的
            if (residue - candidates[i] < 0) {
                break;
            }

            // 小剪枝 减去重复结果集
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, residue - candidates[i], path, res);

            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;

    }


}

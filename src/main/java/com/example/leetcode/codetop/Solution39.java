package com.example.leetcode.codetop;

import java.util.*;


public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        this.dfs(candidates, 0, target, path, res);
        return res;
    }

    /**
     * @param candidates
     * @param begin      这里不能用cur 加的方式,而是应该用减的方式,这样才能理解到怎么去重.如果用了某个数为起点.
     *                   那之后的树应该剪掉这个数,不然会造成重复
     * @param target
     * @param path
     * @param res
     */
    private void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {


        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 设置begin去重
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);

            // 用i的话, 如果当前是第二个数,下一层循环也只能用到第二个数.
            dfs(candidates, i, target - candidates[i], path, res);

            // 进行回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] candidates = {2, 3, 6, 7};
        int target = 8;
        List<List<Integer>> lists = solution39.combinationSum(candidates, target);
        System.out.println(lists);
    }
}

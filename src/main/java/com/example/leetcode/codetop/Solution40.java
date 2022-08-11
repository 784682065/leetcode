package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution40 {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        int begin = 0;
        dfs(candidates, path, begin, target);
        return res;
    }

    private void dfs(int[] candidates, List<Integer> path, int begin, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            dfs(candidates, path, i + 1, target - candidates[i]);
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        Solution40 solution40 = new Solution40();
        System.out.println(solution40.combinationSum2(candidates, 8));

    }
}

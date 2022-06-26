package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int begin = -1;
        this.dfs(nums, begin, path, res);

        return res;
    }

    private void dfs(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> res) {

        res.add(new ArrayList<>(path));
        begin += 1;

        for (int i = begin; i < nums.length; i++) {

            path.addLast(nums[i]);
            // 递归调用
            dfs(nums, i, path, res);

            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution78.subsets(nums);
        System.out.println(subsets);
    }

}

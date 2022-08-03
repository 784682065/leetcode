package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Soluiton78_1 {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        //空集
        Deque<Integer> path = new ArrayDeque<>();


        dfs(nums, res, 0, path);


        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int begin, Deque<Integer> path) {
        res.add(new ArrayList<>(path));

        for (int i = begin; i < nums.length; i++) {

            path.addLast(nums[i]);
            dfs(nums, res, ++begin, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {

    }

}

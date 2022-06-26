package com.example.leetcode.codetop;

import java.util.*;

public class Solution47 {


    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) {
            return res;
        }

        boolean[] visted = new boolean[nums.length];
        Map<Integer,List<Integer>> usedNums = new HashMap<>();

        List<Integer> path = new ArrayList<>();
        dfs(res, nums, path, visted, usedNums);


        return res;
    }


    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] visted, Map<Integer,List<Integer>> usedNums) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            usedNums.remove(path.size());
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            // 如果未曾访问, 则加入path
            // 现在这个值要放哪一层? 如果这层放过这一个值则就不能再放了
            if (!visted[i] && !(usedNums.getOrDefault(path.size(),new ArrayList<>()).contains(nums[i]))){
                // 设置为访问
                visted[i] = true;
                List<Integer> orDefault = usedNums.getOrDefault(path.size(), new ArrayList<>());
                orDefault.add(nums[i]);
                usedNums.put(path.size(), orDefault);
                path.add(nums[i]);

                dfs(res,nums,path,visted,usedNums);
                // 回溯
                visted[i] = false;
                path.remove(path.size()-1);
            }
        }
        usedNums.remove(path.size());
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution47 solution = new Solution47();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }

}

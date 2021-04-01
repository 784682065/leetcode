package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huzp
 * @Description: 全排列
 * @Date: Created in  11:10 2020/1/12
 * @param:
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //特解判断
        if (len == 0) return res;
        //标记
        boolean used[] = new boolean[len];
        //初始路径
        List<Integer> path = new ArrayList<>();

        dfs(nums, used, len, 0, path, res);

        return res;
    }

    /**
     *
     * @param nums 数组
     * @param used 标记数组
     * @param len 数组长度
     * @param depth 深度
     * @param path 路径
     * @param res 结果值
     */
    private void dfs(int[] nums, boolean[] used,
                     int len, int depth,
                     List<Integer> path,
                     List<List<Integer>> res) {
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(!used[i]){

                path.add(nums[i]);
                used[i] = true;
                dfs(nums,used,len,depth +1 ,path ,res);

                used[i] = false;
                path.remove(depth);
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution46 solution = new Solution46();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);

    }

}

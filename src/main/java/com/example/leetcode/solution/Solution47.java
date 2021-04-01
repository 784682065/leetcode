package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  14:47 2020/1/14
 * @param:
 */
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //特解判断
        if (len == 0) return res;

        Arrays.sort(nums);
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
                //剪枝 !used[i - 1] 如果之前一个没有使用过且与现在的nums【i】一样 则需要剪掉
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }

                path.add(nums[i]);
                used[i] = true;
                dfs(nums,used,len,
                        depth +1 ,path ,res);

                used[i] = false;
                path.remove(depth);
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution47 solution = new Solution47();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);

    }
}

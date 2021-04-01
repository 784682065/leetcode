package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  17:09 2020/1/17
 * @param:
 */
public class Solution90 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        int length = nums.length;
        if (length == 0) return res;

        //空集
        List<Integer> list = new ArrayList<>();

        //排序
        Arrays.sort(nums);

        boolean[] used = new boolean[length];

        dfs(nums,list,length,0,used);



        return res;
    }

    private void dfs(int[] nums , List<Integer> list  , int length, int start, boolean[] used ) {

        //如果上一个元素与现在这个一样则 剪枝
        if(start > 1  && !used[start-2] && nums[start-2] == nums[start -1]) return;

        res.add(new ArrayList<>(list));

        //循环加入元素
        for (int i = start ; i < length; i++) {
            list.add(nums[i]);
            used[i] = true;
            dfs(nums,list,length,i+1,used);

            //回溯
            used[i] = false;
            list.remove(list.size() -1 );
        }

    }

    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        int[] nums = {1,2,2};
        List<List<Integer>> subsets = solution90.subsetsWithDup(nums);
        System.out.println(subsets.toString());
    }
}

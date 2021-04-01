package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: huzp
 * @Description: 子集
 * @Date: Created in  15:48 2020/1/17
 * @param:
 */
public class Solution78 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        int length = nums.length;
        if (length == 0) return res;

        //空集
        List<Integer> list = new ArrayList<>();

        //排序
        Arrays.sort(nums);

        dfs(nums,list,length,0);



        return res;
    }

    private void dfs(int[] nums , List<Integer> list  ,int length, int start ) {


        if (start > length) return;


        res.add(new ArrayList<>(list));

        //循环加入元素
        for (int i = start ; i < length; i++) {
            list.add(nums[i]);
            dfs(nums,list,length,i+1);
            //回溯
            list.remove(list.size() -1 );
        }

    }

    public static void main(String[] args) {

        Solution78 solution78 = new Solution78();

        int[] nums = {1,2,2};

        List<List<Integer>> subsets = solution78.subsets(nums);
        System.out.println(subsets.toString());


    }


}

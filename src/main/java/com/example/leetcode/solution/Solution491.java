package com.example.leetcode.solution;

import java.util.*;

/**
 * describe: 查询所有子序列
 *
 * @Author: Huzp
 * @Date: 2020-04-27 14:04
 */
public class Solution491 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        //一定要在外面传入list ,方便里面修改
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> es) {

        //边界找到最后一个了就不在寻找
        if (index > nums.length - 1) {
            if (es.size() >= 2) {
                res.add(new ArrayList<>(es));
            }
            return;
        }

        //最关键的dfs 一步
        //若list 为空或者该索引值的num 小于list的最后一位
        if (es.isEmpty() || nums[index] >= es.get(es.size() - 1)) {
            es.add(nums[index]);
            //继续下一次dfs
            dfs(nums, index + 1, es);

            //最容易遗忘的一步,回溯
            //相当于回到上一步没添加nums[index] 的状态,
            // 然后给下面的 不添加这个值一个分支
            /**
             * 注意点回溯
             */
            es.remove(es.size() - 1);
        }

        //2,3,7,7 最后一个7被移除之后, 不再加入
        //但是如果这个时候index为0 的话还可以加入
        //list 为empty的话也可以加入
        if (index > 0 && !es.isEmpty() && nums[index] == es.get(es.size() - 1)) {
            return;
        }
        //跳过加入这个值
        dfs(nums, index + 1, es);

    }


    public boolean isValid(String s) {
        // Hash table that takes care of the mappings.
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket. 若map 中key 值有个闭合框
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}



package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {

        int[] ans = new int[nums.length * 2];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans,-1);

        // 第一轮
        for (int j = 0; j < nums.length; j++) {
            while (!stack.isEmpty() &&  nums[stack.peek()] < nums[j]){
                //index 位置
                Integer pop = stack.pop();
                ans[pop] = nums[j];
            }
            stack.push(j);
        }


        for (int num : nums) {
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                //index 位置
                Integer pop = stack.pop();
                ans[pop] = num;
            }
        }

        int[] res = new int[nums.length];
        System.arraycopy(ans,0, res, 0, res.length);
        return res;
    }


    public int[] nextGreaterElementsOF(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        // 使用% 替代,这样代码更好看,也不用 System.copy
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        Solution503 solution503 = new Solution503();
        System.out.println(Arrays.toString(solution503.nextGreaterElements(nums)));


    }
}

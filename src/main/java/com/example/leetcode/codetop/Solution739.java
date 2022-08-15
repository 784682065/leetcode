package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.Stack;

public class Solution739 {



    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        // stack 存放index
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int cur= temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]){
                Integer index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        // 下一个最高温度在几天后出现
//    输入: temperatures = [73,74,75,71,69,72,76,73]
//    输出: [1,1,4,2,1,1,0,0]
        int[] temperatures = {73,74,75,71,69,72,76,73};
        Solution739 solution739 = new Solution739();
        System.out.println(Arrays.toString(solution739.dailyTemperatures(temperatures)));

    }
}
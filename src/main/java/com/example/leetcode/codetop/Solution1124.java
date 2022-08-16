package com.example.leetcode.codetop;

import java.util.Stack;

public class Solution1124 {

    public static int longestWPI(int[] hours) {
        int n = hours.length;
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = hours[i] > 8 ? 1 : -1;
        }
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] += preSum[i - 1] + aux[i - 1];
        }
        Stack<Integer> stk = new Stack<>();
        // 从0 开始找到一个递减数列,说明休息的比较多的数列
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty() || preSum[stk.peek()] > preSum[i]) {
                stk.push(i);
            }
        }

        int res = 0;
        // 从末尾开始找大于栈中的数 j,大于栈中的数 i,
        // 说明,  j -i 总共的时间是加班的比较多
        for (int i = n; i >= 0; i--) {
            while(!stk.isEmpty() && preSum[i] > preSum[stk.peek()]) {
                res = Math.max(i - stk.pop(), res);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] hours = {9,9,6,0,6,6,9};
        longestWPI(hours);
    }

}

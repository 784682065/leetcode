package com.example.leetcode.codetop;

import java.util.Stack;

public class Solution962 {

//    public int maxWidthRamp(int[] nums) {
//        int ans= 0;
//        for (int i = 0; i < nums.length -1; i++) {
//            int ai = nums[i];
//            for (int j = nums.length -1; j >i ; j--) {
//                int aj = nums[j];
//                if (aj >= ai){
//                    ans = Math.max(j -i , ans);
//                }
//            }
//        }
//        return ans;
//    }
public int maxWidthRamp(int[] A) {

    int n = A.length;
    int maxWidth = 0;

    Stack<Integer> stack = new Stack<>();
    // 找递减栈的index
    for (int i=0;i<n;i++) {
        if (stack.isEmpty() || A[stack.peek()] > A[i]) {
            stack.push(i);
        }
    }

    for (int i=n-1;i>=0;i--) {
        while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
            int pos = stack.pop();
            maxWidth = Math.max(maxWidth, i - pos);
        }
    }
    return maxWidth;
}

    public static void main(String[] args) {
        int[] arr = {6, 1, 8, 2, 0, 5};
        Solution962 solution962 = new Solution962();
        System.out.println(solution962.maxWidthRamp(arr));
    }
}

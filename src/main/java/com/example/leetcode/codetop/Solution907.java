package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution907 {

//    public int sumSubarrayMins(int[] arr) {
//        // 超时
//        int sum = 0;
//        int MOD = 1_000_000_007;
//        Deque<Integer> deque;
//        for (int end = arr.length - 1; end >= 0; end--) {
//            deque = new ArrayDeque<>();
//            for (int j = end; j >= 0; j--) {
//                if (deque.isEmpty() || deque.peekFirst() > arr[j]) {
//                    deque.offerFirst(arr[j]);
//                } else {
//                    deque.offerFirst(deque.peekFirst());
//                }
//                sum += deque.peekFirst();
//                sum %= MOD;
//            }
//        }
//        return  sum;
//    }

    /**
     * 比如输入[1,3,2]
     * dot = 0, ans = 0
     * <p>
     * 首先，1入栈，dot += 1 * 1，这个加上的1对应区间为[1]， ans += dot, ans = 1
     * <p>
     * 然后，3入栈，dot += 3 * 1 ，即dot = 4 = 1 + 3，这里的1对应的区间为[1, 3], 3对应的区间为[3]，
     * ans += dot，ans = 1 + （1 + 3），对应的区间为[1], [1,3], [3]
     * <p>
     * 最后，2入栈前将3弹出栈，弹出的时候dot -= 3 * 1, dot = 1，这个剩下的1对应区间是[1,3]，
     * 被减去的3代表区间[3]，因为[3,2]的最小值是2，在后面2入栈的时候才会累加上来，所以现在就需要将其剔除。
     * 2入栈时，count = 2，即两个区间[3,2],[2]的最小值都是2。
     * dot += 2 * 2，dot = 1 + 2 + 2，
     * 对应的区间为[1,3,2], [3,2], [2]，
     * ans += dot,
     * ans = 1 + (1 + 3) + (((1 + 3) - 3) + 2 + 2) = 1 + (1 + 3) + (1 + 2 + 2)。
     * 对应区间为[1], [1,3], [3],[1,3,2],[3,2],[2]
     */
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;

        Stack<RepInteger> stack = new Stack();
        // dot 是当前最小值栈的和
        int ans = 0, dot = 0;
        for (int j = 0; j < A.length; ++j) {
            // Add all answers for subarrays [i, j], i <= j
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= A[j]) {
                RepInteger node = stack.pop();
                count += node.count;
                // 如果比上一个值小的话,就减去这个区间的上个值,这个区间的这个值 次数加1
                dot -= node.val * node.count;
            }
            stack.push(new RepInteger(A[j], count));
            dot += A[j] * count;
            ans += dot;
            ans %= MOD;
        }

        return ans;
    }

    class RepInteger {
        int val, count;

        RepInteger(int v, int c) {
            val = v;
            count = c;
        }
    }




    public static void main(String[] args) {
//        int[] arr = {1,7,5,2,4,3,9};
        int[] arr = {1,7,5};
        Solution907 solution907 = new Solution907();
        System.out.println(solution907.sumSubarrayMins(arr));
    }


}

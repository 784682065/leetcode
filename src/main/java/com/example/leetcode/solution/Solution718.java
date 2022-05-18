package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/5/17
 * @description:
 */
public class Solution718 {


    // 这里的dp[i][j] 并没有代表 A[i:] 和 B[j:] 的最长公共前缀,
    // 只是记录了A[i+1:] 与 B[j+1:] 有没有在 i j这两个节点有没有续上而已,
    // 所以需要ans 记录最大的前缀值
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


    public int findLength_1(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution718 solution718 = new Solution718();
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        solution718.findLength_1(A,B);
    }
}

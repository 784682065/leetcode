package com.example.leetcode.codetop;

public class Solution718 {


    public int findLength(int[] nums1, int[] nums2) {

        int m = nums2.length;
        int n = nums1.length;
        int ans = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (nums2[i - 1] == nums1[j - 1]) {
                    // 上面和左边
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    // 这里无法传递,不然会变成求不连续最长重合子串
                    dp[i][j] = 0;
                }

                ans = Math.max(dp[i][j],ans);
            }

        }
        return ans;
    }


    public int findLengthOF(int[] A, int[] B) {
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
        int[] n1 = {0, 1, 1, 1, 1};
        int[] n2 = {1, 0, 1, 0, 1};
        Solution718 solution718 = new Solution718();
        System.out.println(solution718.findLengthOF(n1, n2));
    }
}

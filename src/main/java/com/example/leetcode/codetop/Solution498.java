package com.example.leetcode.codetop;

import java.util.Arrays;

public class Solution498 {

    // 斜上,有值接右,无值接下,   斜下有值接下,无值接右
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++) {
            // 奇数斜上线, x能超过上限, y能超过下线
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            } else {
                // 偶数斜下线, x能超过下线, y能超过上限
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };

        Solution498 solution498 = new Solution498();
        System.out.println(Arrays.toString(solution498.findDiagonalOrder(mat)));

    }
}

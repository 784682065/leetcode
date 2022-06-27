package com.example.leetcode.codetop;

import javax.crypto.spec.PSource;
import java.util.Arrays;

public class Solution733 {

    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] visted = new boolean[image.length][image[0].length];


        this.dfs(image, sr, sc, image[sr][sc], color, visted);


        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldcolor, int color, boolean[][] visted) {

        visted[sr][sc] = true;
        image[sr][sc] = color;
        for (int[] ints : move) {
            int nsr = sr + ints[0];
            int nsc = sc + ints[1];
            // 如果在范围内, 没有参观过 , 且为1,那就涂改颜色,并且传递
            if (nsr >= 0 && nsr < image.length && nsc >= 0 && nsc < image[0].length &&
                    !visted[nsr][nsc] && image[nsr][nsc] == oldcolor) {
                dfs(image, nsr, nsc, oldcolor, color, visted);
            }
        }
    }

    public static void main(String[] args) {
        Solution733 solution733 = new Solution733();
        int[][] image = {
                {1,1,1},{1,1,0},{1,0,1}
        };
        int[][] ints = solution733.floodFill(image, 1, 1, 2);
        System.out.println(Arrays.deepToString(ints));

    }
}

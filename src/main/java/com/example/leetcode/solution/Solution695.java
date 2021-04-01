package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-29 14:44
 */
public class Solution695 {

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,0}};
        Solution695 solution695 = new Solution695();
        System.out.println(solution695.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;
        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[0].length; l++) {
                ans = Math.max(dfs(grid, k, l), ans);
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {

        if ( i  == grid.length   || j  == grid[0].length  || i  < 0 || j  < 0 || grid[i][j] == 0 ) {
            return 0;
        }

        int count = 1;
        //每次只能往左和下搜索,搜索到1 count +1 ,找最大的count

        if (grid[i][j] == 1) {
            //找到过就置为0
            grid[i][j] = 0;
            //四个角落开始找
            count += dfs(grid, i + 1, j);
            count += dfs(grid, i, j + 1);
            count += dfs(grid, i, j - 1);
            count += dfs(grid, i - 1, j);

        }

        return count;
    }
}

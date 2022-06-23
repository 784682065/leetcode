package com.example.leetcode.codetop;

public class Solution200 {

    int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;

    public int numIslands(char[][] grid) {


        int res = 0;
        visited = new boolean[grid.length][grid[0].length];

        // 找到一个1 就往外拓展
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j);
                    ++res;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int i, int j) {

        visited[i][j] = true;
        for (int[] ints : move) {
            int r = ints[0] + i;
            int c = ints[1] + j;
            if (inArea(r, c, grid) && !visited[r][c] && grid[r][c] == '1') {
                bfs(grid, r, c);
            }
        }
    }

    private boolean inArea(int i, int j, char[][] grid) {
        return i < grid.length && i >= 0 && j < grid[i].length && j >= 0;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        Solution200 solution200 = new Solution200();
        int i = solution200.numIslands(grid);
        System.out.println(i);

    }

}

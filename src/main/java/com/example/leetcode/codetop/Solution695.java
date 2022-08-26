package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution695 {

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] used = new boolean[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 用bfs 来做
                // 没走过,且为1,即可开始遍历
                if (!used[i][j] && grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    used[i][j] = true;
                    int count = 1;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int[] ints : dir) {
                            int xIdx = poll[0] + ints[0];
                            int yIdx = poll[1] + ints[1];
                            // 四个方向遍历, 如果在范围内 且为1,且未曾used
                            if (inArea(xIdx, yIdx, m, n) && !used[xIdx][yIdx] && grid[xIdx][yIdx] == 1) {
                                queue.offer(new int[]{xIdx, yIdx});
                                used[xIdx][yIdx] = true;
                                count++;
                            }
                        }
                    }
                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }

    private boolean inArea(int xIdx, int yIdx, int m, int n) {
        return xIdx >= 0 && xIdx < m && yIdx >= 0 && yIdx < n;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        Solution695 solution695 = new Solution695();
        System.out.println(solution695.maxAreaOfIsland(grid));


    }

}

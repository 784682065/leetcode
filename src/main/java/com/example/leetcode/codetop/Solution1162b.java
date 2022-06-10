package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1162b {

    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int n;
    int[][] grid;

    public int maxDistance(int[][] grid) {

        this.n = grid.length;
        this.grid = grid;

        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // 去找最近的岛屿
                    ans = Math.max(ans, findNearestLand(i, j));
                }

            }
        }

        return ans;
    }

    private int findNearestLand(int i, int j) {
        // 判断有无遍历过, 之前没写出来就是感觉为什么要判断有无遍历,
        // 实际上,遍历过说明该地方已经加入了队列不能重复遍历.
        boolean[][] vis = new boolean[n][n];
        vis[i][j] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        // 初始遍历点
        queue.offer(new int[]{i, j, 0});
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                for (int[] m : move) {
                    assert cur != null;
                    int r2 = cur[0] + m[0];
                    int c2 = cur[1] + m[1];
                    if (!inArea(r2, c2))
                        continue;
                    // 没有用好vis数组
                    if (!vis[r2][c2]) {

                        // 设置该点遍历过,并且加入队列
                        vis[r2][c2] = true;
                        queue.add(new int[]{r2, c2, cur[2] + 1});
//                        但是如果该店是陆地的话直接返回距离,即为开始点便利的最近的岛屿距离
                        if (this.grid[r2][c2] == 1) {
                            // 距离 加1
                            vis[r2][c2] = true;
                            return cur[2] + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }

    public boolean inArea(int r, int c) {
        return r >= 0 && c >= 0 && r < this.n && c < this.n;
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        Solution1162b solution1162b = new Solution1162b();
        int i = solution1162b.maxDistance(grid);
        System.out.println(i);


    }
}

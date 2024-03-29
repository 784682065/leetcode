package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1162 {

    public int maxDistance(int[][] grid) {
        int N = grid.length;

        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有的陆地格子加入队列
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 如果地图上只有陆地或者海洋，返回 -1
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }

        int[][] moves = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
        };

        // 多源层析遍历
        int distance = -1; // 记录当前遍历的层数（距离）
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] node = queue.poll();
                int r = node[0];
                int c = node[1];
                for (int[] move : moves) {
                    int r2 = r + move[0];
                    int c2 = c + move[1];
                    // 已经被遍历过得海洋,说明该海洋已经找到了距离最近的,所以不需要别的陆地再来遍历他
                    if (inArea(grid, r2, c2) && grid[r2][c2] == 0) {
                        grid[r2][c2] = 2; // 这样就不需要vis数据设置标记
                        queue.add(new int[]{r2, c2});
                    }
                }
            }
        }

        return distance;
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

}

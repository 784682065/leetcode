package com.example.leetcode.ttt;

import java.util.*;

public class Mainh3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }

        System.out.println(calMaxBlackArea(nums));
    }

    // 更改两个0 --> 1  ,联通最大的面积

    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};
    static int[][] grid;
    static int N,M;

    private static int calMaxBlackArea(int[][] grid1) {
        grid = grid1;
        N = grid.length;
        M = grid[0].length;

        int index = 2;
        int[] area = new int[N*M + 2];
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] == 1)
                    area[index] = dfs(r, c, index++);

        int ans = 0;


        int len = 3;


//        for (int x: area) ans = Math.max(ans, x);
//        for (int r = 0; r < N; ++r)
//            for (int c = 0; c < N; ++c)
//                if (grid[r][c] == 0) {
//                    Set<Integer> seen = new HashSet<>();
//                    for (Integer move: neighbors(r, c))
//                        if (grid[move / N][move % N] > 1)
//                            seen.add(grid[move / N][move % N]);
//
//                    int bns = 1;
//                    for (int i: seen) bns += area[i];
//                    ans = Math.max(ans, bns);
//                }

        return ans;
    }
    public static int dfs(int r, int c, int index) {
        int ans = 1;
        grid[r][c] = index;
        for (Integer move: neighbors(r, c)) {
            if (grid[move / N][move % N] == 1) {
                grid[move / N][move % N] = index;
                ans += dfs(move / N, move % N, index);
            }
        }
        return ans;
    }

    public static List<Integer> neighbors(int r, int c) {
        List<Integer> ans = new ArrayList();
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < N)
                ans.add(nr * N + nc);
        }

        return ans;
    }



}

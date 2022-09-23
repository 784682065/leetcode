package com.example.leetcode.codetop;

public class Solution79 {


    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean res;

//    public boolean exist(char[][] board, String word) {
//
//        int m = board.length;
//        int n = board[0].length;
//        boolean[][] visted = new boolean[m][n];
//        res = false;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    visted[i][j] = true;
//                    dfs(i, j, 1, visted, word, board);
//                    if (res) {
//                        return true;
//                    }
//                    visted = new boolean[m][n];
//                }
//
//            }
//        }
//
//
//        return false;
//    }
//
//    private void dfs(int i, int j, int begin, boolean[][] visted, String word, char[][] board) {
//        if (begin >= word.length()) {
//            res = true;
//            return;
//        }
//
//        for (int[] ints : dir) {
//            int row = i + ints[0];
//            int clo = j + ints[1];
//
//            if (inArea(row, clo, board) && !visted[row][clo] && word.charAt(begin) == board[row][clo]) {
//                visted[row][clo] = true;
//                dfs(row, clo, begin + 1, visted, word, board);
//            }
//
//        }
//    }

//    private boolean inArea(int row, int clo, char[][] board) {
//        return row >= 0 && row < board.length && clo >= 0 && clo < board[0].length;
//    }

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        // 必须回溯,而不是在主函数里统一置为false,不会会导致 A可以去B点或者C点,去了B点以后,后面绕弯不能再绕到C点了
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'A'},{'A'}};
        String word = "AAA";
        Solution79 solution79 = new Solution79();
        System.out.println(solution79.exist(board, word));

    }
}

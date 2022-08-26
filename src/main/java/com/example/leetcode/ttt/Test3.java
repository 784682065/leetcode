package com.example.leetcode.ttt;
import java.util.*;
public class Test3 {

    static int[][] mmap;
    static String str;
    static Deque<Node> res;
    static int min;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

//    [[0,1,1,1],[0,0,0,1],[1,0,8,1],[1,0,1,1]]
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        mmap = new int[4][4];
        int ind = 2;
        int start_x = 0, start_y = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mmap[i][j] = str.charAt(ind + (j * 2)) - '0';
                if (mmap[i][j] == 8) {
                    start_x = i;
                    start_y = j;
                }
            }
            ind += 10;
        }

        Deque<Node> q = new ArrayDeque<>();
        q.addLast(new Node(start_x, start_y));
        min = Integer.MAX_VALUE;
        res = new ArrayDeque<>();
        boolean[][] used = new boolean[4][4];
        used[start_x][start_y] = true;
        dfs(q, used);
        System.out.print("[");
        while (!res.isEmpty()){
            System.out.print(res.pollFirst());
        }
        System.out.println("]");

    }

    private static void dfs(Deque<Node> q, boolean[][] used) {
        if (q.size() >=min){
            return;
        }
        // 判断当前点是否在边缘
        Node node = q.peekLast();
        if ( isBY(node)) {
            res = new ArrayDeque<>(q);
            return;
        }
        for (int[] ints : dir) {
            int xIdx = node.x + ints[0];
            int yIdx = node.y + ints[1];
            if (!used[xIdx][yIdx] && mmap[xIdx][yIdx] !=1){
                q.addLast(new Node(xIdx, yIdx));
                used[xIdx][yIdx] = true;
                dfs(q,used);
                q.pollLast();
                used[xIdx][yIdx] = false;
            }
        }
    }

    private static boolean isBY(Node node) {
        return (node.x == 0 || node.x == 3 || node.y == 0 || node.y == 3);
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" + x + "," + y + '}';
        }
    }

}

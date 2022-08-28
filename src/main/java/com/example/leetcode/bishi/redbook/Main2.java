package com.example.leetcode.bishi.redbook;


import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] degree = new int[n];
        boolean[] used = new boolean[n];
        Queue<int[]> friends = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            // 朋友编号
            int num = scanner.nextInt();
            // 当前人编号
            int cur = i;
            // 互相为朋友
            // 计算度
            ++degree[num - 1];
            ++degree[cur];
            friends.add(new int[]{num - 1, cur});
        }
        int ans = 0;
        while (true) {
            int[] one = new int[2];
            for (int[] friend : friends) {
                int a = friend[0];
                int b = friend[1];
                if (used[a] || used[b]) {
                    continue;
                }
                if (one[0] == 0 && one[1] == 0) {
                    one = friend;

                } else if (degree[a] * degree[b] < degree[one[0]] * degree[one[1]]) {
                    //寻找度最小的
                    one = friend;
                }
            }
            if (one[0] == 0 && one[1] == 0) {
                break;
            }else {
                // 用掉
                used[one[0]] = true;
                used[one[1]] = true;
                ++ans;
            }
        }
        System.out.println(ans);
    }
}

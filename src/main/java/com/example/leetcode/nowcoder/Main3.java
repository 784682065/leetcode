package com.example.leetcode.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main3 {


    static int res;

    public  void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] s2 = s1.split(" ");
        int length = Integer.parseInt(s2[0]);
        int distance = Integer.parseInt(s2[1]);

        String strs = scanner.nextLine();
        String[] s = strs.split(" ");
        List<Integer> position = Arrays.stream(s).map(Integer::valueOf).collect(Collectors.toList());

        Deque<Integer> path = new LinkedList<>();
        res = 0;
        dfs(distance, 0, length, position, path);
        System.out.println(res);

    }

    public static void dfs(int distance, int begin, int length, List<Integer> position, Deque<Integer> path) {

        if (path.size() == 3) {
            ++res;
            return;
        }

        for (int i = begin; i < length; i++) {
            // 看看能不能加入
            if (!path.isEmpty()) {
                if (position.get(i) - path.getFirst() > distance) {
                    return;
                }
            }

            path.addLast(position.get(i));
            dfs(distance, i + 1, length, position, path);
            path.removeLast();
        }
    }


    private int mod = 99997867;

    private void sln() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), D = sc.nextInt();
        long cnt = 0;
        if (N <= 2) {
            System.out.println(-1);
            return;
        }
        int[] locs = new int[N];
        for (int i = 0; i < N; i++) {
            locs[i] = sc.nextInt();
        }
        sc.close();
        int left = 0, right = 2;
        while (right < N) {
            if (locs[right] - locs[left] > D) left++;
            else if (right - left < 2) right++;
            else {
                cnt += calC(right - left);
                right++;
            }
        }
        cnt %= mod;
        System.out.println(cnt);
    }

    private long calC(long num) {
        return num * (num - 1) / 2;
    }
}

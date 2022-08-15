package com.example.leetcode.netez;

import java.util.*;

public class Main {

    static boolean res;
    static boolean[] visted;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 拿到宝箱序列号
        String s = scanner.nextLine();
        res = false;
        // 宝箱序列号
        List<List<Integer>> tokens = new ArrayList<>();
        // 已有宝箱
        Deque<Integer> haved = new ArrayDeque<>();


        s = s.substring(1, s.length() - 1);

        int begin = 0;
        while (begin < s.length()) {
            int start = -1, end = -1;
            for (int i = begin; i < s.length(); i++) {
                char charAt = s.charAt(i);
                if (charAt == '[') {
                    start = i;
                    continue;
                }
                if (charAt == ']') {
                    end = i;
                    break;
                }
            }
            String[] split = s.substring(start + 1, end).split(",");
            List<Integer> token = new ArrayList<>();
            if (!split[0].isEmpty()) {
                for (String value : split) {
                    token.add(Integer.parseInt(value));
                }
            }
            tokens.add(token);
            begin = end + 1;
        }
        res = false;
        // 未开宝箱数量
        int n = tokens.size();
        visted = new boolean[n];
        visted[0] = true;
        --n;
        haved.addAll(new ArrayDeque<>(tokens.get(0)));

        dfs(n, visted, haved, tokens);
        System.out.println(res);
    }

    private static void dfs(int n, boolean[] used, Deque<Integer> haved, List<List<Integer>> tokens) {

        while (!haved.isEmpty()){
            Integer poll = haved.poll();
//            --poll;
            if (!visted[poll]){
                visted[poll] = true;
                n--;
                haved.addAll(new ArrayDeque<>(tokens.get(poll)));
            }
        }
        if (n == 0) {
            res = true;

        }
    }
}

package com.example.leetcode.bishi.xiecheng;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    static int totalR, totalG, totalB;
    static int curR, curG, curB;
    static char[] rgbs;
    static int res;
    static HashMap<Integer, List<Integer>> trees;

    public static void main(String[] args) {

        res = 0;
        totalR = 0;
        totalG = 0;
        totalB = 0;
        curR = 0;
        curG = 0;
        curB = 0;
        trees = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        rgbs = new char[n + 1];
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == 'r') {
                totalR++;
            } else if (charAt == 'g') {
                totalG++;
            } else {
                totalB++;
            }
            rgbs[i + 1] = charAt;
        }

        int root = -1;
        for (int i = 1; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            int node1 = Integer.parseInt(s[0]);
            int node2 = Integer.parseInt(s[1]);
            if (i == 1) {
                root = node1;
            }
            List<Integer> orDefault = trees.getOrDefault(node1, new ArrayList<>());
            orDefault.add(node2);
            trees.put(node1, orDefault);
        }
        dfs(root);
        System.out.println(res);
    }

    private static void dfs(int root) {
        List<Integer> list = trees.get(root);
        if (list != null) {
            for (Integer node : list) {
                dfs(node);
                if ((curR >= 1 && curG >= 1 && curB >= 1) &&
                        (totalR - curR >= 1 && totalG - curG >= 1 && totalB - curB >= 1)) {
                    ++res;
                    totalR -= curR;
                    totalG -= curG;
                    totalB -= curB;
                    curR = 0;
                    curG = 0;
                    curB = 0;
                }
            }
        }

        char color = rgbs[root];
        if (color == 'r') {
            curR++;
        } else if (color == 'g') {
            curG++;
        } else {
            curB++;
        }
    }
}
